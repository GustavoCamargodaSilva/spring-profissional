package com.springprofissional.dscommerce.controllers;

import com.springprofissional.dscommerce.dto.OrderDTO;
import com.springprofissional.dscommerce.dto.ProductDTO;
import com.springprofissional.dscommerce.dto.ProductMinDTO;
import com.springprofissional.dscommerce.entities.Order;
import com.springprofissional.dscommerce.services.OrderService;
import com.springprofissional.dscommerce.services.ProductService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.net.URI;

@RestController  //Configurar para que quando a aplicaçao rodar o que implementar na classe seja respodindo pela web
@RequestMapping(value = "/orders") //Essa vai ser a rota pela qual vai ser respondido pela web
public class OrderController {

    @Autowired
    private OrderService service;

    @PreAuthorize("hasRole('ROLE_ADMIN')")
    @GetMapping(value = "/{id}") //esse id vai casar com o parametro do metodo
    public ResponseEntity<OrderDTO> findById(@PathVariable Long id){ //retornar um reponseentity do tipo dto
        OrderDTO dto = service.findById(id);
        return ResponseEntity.ok(dto); //pontoOK vai retornar o codigo 201 que é o correto
    }

    @PreAuthorize("hasRole('ROLE_CLIENT')")
    @PostMapping
    public ResponseEntity<OrderDTO> insert(@Valid @RequestBody OrderDTO dto){
        dto = service.insert(dto);
        URI uri = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}")
                .buildAndExpand(dto.getId()).toUri();
        return ResponseEntity.created(uri).body(dto);
    }

}
