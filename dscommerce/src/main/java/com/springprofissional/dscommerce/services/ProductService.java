package com.springprofissional.dscommerce.services;

import com.springprofissional.dscommerce.dto.ProductDTO;
import com.springprofissional.dscommerce.entities.Product;
import com.springprofissional.dscommerce.repositories.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
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

    @Transactional(readOnly = true) //retorna lista paginada de produtos
    public Page<ProductDTO> findAll(Pageable pageable){  //tambem precisa passar o pageable

        Page<Product> result = repository.findAll(pageable); //tipo page que recebe listado
        return result.map(x -> new ProductDTO(x));
    }
}
