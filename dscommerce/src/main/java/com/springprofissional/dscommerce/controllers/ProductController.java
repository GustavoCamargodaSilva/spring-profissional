package com.springprofissional.dscommerce.controllers;

import com.springprofissional.dscommerce.dto.ProductDTO;
import com.springprofissional.dscommerce.entities.Product;
import com.springprofissional.dscommerce.repositories.ProductRepository;
import com.springprofissional.dscommerce.services.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.web.bind.annotation.*;

import javax.swing.text.html.Option;
import java.util.List;
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

    @GetMapping //get de todos os produtos da lista paginados
    public Page<ProductDTO> findAll(Pageable pageable){ //Pageable quer dizer que ele vai me retornar os resultados paginados
        return service.findAll(pageable);
    }
    @PostMapping //metodo para criar um produto
    public ProductDTO insert(@RequestBody ProductDTO dto){ //RequestBody faz com que o corpo correspondente do json corresponda e instancie um dto quando chamado o metodo
       return service.insert(dto);
    }






}
