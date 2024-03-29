package com.springprofissional.dscommerce.controllers;

import com.springprofissional.dscommerce.dto.ProductDTO;
import com.springprofissional.dscommerce.dto.ProductMinDTO;
import com.springprofissional.dscommerce.entities.Product;
import com.springprofissional.dscommerce.repositories.ProductRepository;
import com.springprofissional.dscommerce.services.ProductService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import javax.swing.text.html.Option;
import java.net.URI;
import java.util.List;
import java.util.Optional;

@RestController  //Configurar para que quando a aplicaçao rodar o que implementar na classe seja respodindo pela web
@RequestMapping(value = "/products") //Essa vai ser a rota pela qual vai ser respondido pela web
public class ProductController {

    @Autowired
    private ProductService service;

    @GetMapping(value = "/{id}") //esse id vai casar com o parametro do metodo
    public ResponseEntity<ProductDTO> findById(@PathVariable Long id){ //retornar um reponseentity do tipo dto
        ProductDTO dto = service.findById(id);
        return ResponseEntity.ok(dto); //pontoOK vai retornar o codigo 201 que é o correto
    }

    @GetMapping //get de todos os produtos da lista paginados
    public ResponseEntity<Page<ProductMinDTO>> findAll(
            @RequestParam(name = "name",defaultValue = "") String name,
            Pageable pageable){ //Pageable quer dizer que ele vai me retornar os resultados paginados
        Page<ProductMinDTO> dto = service.findAll(name,pageable);
        return ResponseEntity.ok(dto);
    }

    @PreAuthorize("hasRole('ROLE_ADMIN')")
    @PostMapping //metodo para criar um produto   //valid para passar pela validaçao antes de dar insert
    public ResponseEntity<ProductDTO> insert(@Valid @RequestBody ProductDTO dto){ //RequestBody faz com que o corpo correspondente do json corresponda e instancie um dto quando chamado o metodo
       dto = service.insert(dto);
       URI uri = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}")
               .buildAndExpand(dto.getId()).toUri();
       return ResponseEntity.created(uri).body(dto);
    }

    @PreAuthorize("hasRole('ROLE_ADMIN')")
    @PutMapping(value = "/{id}") //esse id vai casar com o parametro do metodo
    public ResponseEntity<ProductDTO> update(@Valid @PathVariable Long id,@RequestBody ProductDTO dto){ //retornar um reponseentity do tipo dto

        dto = service.update(id,dto);
        return ResponseEntity.ok(dto); //pontoOK vai retornar o codigo 201 que é o correto
    }

    @PreAuthorize("hasRole('ROLE_ADMIN')")
    @DeleteMapping(value = "/{id}") //esse id vai casar com o parametro do metodo
    public ResponseEntity<Void> delete(@PathVariable Long id){ //retornar um reponseentity do tipo dto
        service.delete(id);
        return ResponseEntity.noContent().build(); //pontoOK vai retornar o codigo 201 que é o correto
    }

}
