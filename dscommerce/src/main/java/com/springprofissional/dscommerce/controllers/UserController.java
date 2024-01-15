package com.springprofissional.dscommerce.controllers;

import com.springprofissional.dscommerce.dto.ProductDTO;
import com.springprofissional.dscommerce.dto.UserDTO;
import com.springprofissional.dscommerce.services.ProductService;
import com.springprofissional.dscommerce.services.UserService;
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
@RequestMapping(value = "/users") //Essa vai ser a rota pela qual vai ser respondido pela web
public class UserController {

    @Autowired
    private UserService service;

    @PreAuthorize("hasAnyRole('ROLE_ADMIN'),('ROLE_OPERATOR')")
    @GetMapping(value = "/profile") //esse id vai casar com o parametro do metodo
    public ResponseEntity<UserDTO> findProfile(){ //retornar um reponseentity do tipo dto
        UserDTO dto = service.getMe();
        return ResponseEntity.ok(dto); //pontoOK vai retornar o codigo 201 que é o correto
    }

}
