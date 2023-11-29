package com.springprofissional.dscommerce.services;

import com.springprofissional.dscommerce.dto.ProductDTO;
import com.springprofissional.dscommerce.entities.Product;
import com.springprofissional.dscommerce.repositories.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Optional;

@Service
public class ProductService {

    @Autowired
    private ProductRepository repository;

    @Transactional(readOnly = true) //somente de leitura
    public ProductDTO findById(Long id){

        Product product = repository.findById(id).get();
        return new ProductDTO(product);

        //----FORMA MAIS DIDATICA ----//
        //Optional<Product> result = repository.findById(id);
       //Product product = result.get();
        //ProductDTO dto = new ProductDTO(product);
        //return dto;
    }
}
