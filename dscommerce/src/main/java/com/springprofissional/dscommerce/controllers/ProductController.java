package com.springprofissional.dscommerce.controllers;

import com.springprofissional.dscommerce.dto.ProductDTO;
import com.springprofissional.dscommerce.entities.Product;
import com.springprofissional.dscommerce.repositories.ProductRepository;
import com.springprofissional.dscommerce.services.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.swing.text.html.Option;
import java.util.Optional;

@RestController  //Configurar para que quando a aplicaçao rodar o que implementar na classe seja respodindo pela web
@RequestMapping(value = "/products") //Essa vai ser a rota pela qual vai ser respondido pela web
public class ProductController {

    @Autowired
    private ProductService service;
    @GetMapping(value = "/{id}") //esse id vai casar com o parametro do metodo
    public ProductDTO findById(@PathVariable Long id){
        ProductDTO dto = service.findById(id);
        return dto;
    }
}
