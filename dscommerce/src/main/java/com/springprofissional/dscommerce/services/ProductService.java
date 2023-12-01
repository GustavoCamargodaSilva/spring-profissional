package com.springprofissional.dscommerce.services;

import com.springprofissional.dscommerce.dto.ProductDTO;
import com.springprofissional.dscommerce.entities.Product;
import com.springprofissional.dscommerce.repositories.ProductRepository;
import com.springprofissional.dscommerce.services.exceptions.ResourceNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class ProductService {

    @Autowired
    private ProductRepository repository;

    @Transactional(readOnly = true) //somente de leitura
    public ProductDTO findById(Long id){


        Product product = repository.findById(id).orElseThrow(() -> new ResourceNotFoundException("Recurso nao encontrado"));
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

    @Transactional
    public ProductDTO insert(ProductDTO dto){  //Insert no banco de produto dto

        Product entity = new Product(); //cria um novo produto
        CopyDtoToEntity(dto,entity);
        entity = repository.save(entity); //usa o repositorio para salvar o novo produto
        return new ProductDTO(entity);  //converte para retornar um dto no metodo
    }

    @Transactional
    public ProductDTO update(Long id,ProductDTO dto){  //Insert no banco de produto dto

        Product entity = repository.getReferenceById(id); //referenciar produto com o id nao faz busca no banco ainda sendo monitorado pela JPA
        CopyDtoToEntity(dto,entity);
        entity = repository.save(entity); //usa o repositorio para salvar o novo produto
        return new ProductDTO(entity);  //converte para retornar um dto no metodo
    }

    @Transactional
    private void CopyDtoToEntity(ProductDTO dto, Product entity){
        entity.setName(dto.getName()); //faz o set do obj dto que recebe na requisicao no produto
        entity.setDescription(dto.getDescription());
        entity.setPrice(dto.getPrice());
        entity.setImgUrl(dto.getImgUrl());
    }

    @Transactional
    public void delete(Long id){   //Nao retorna nada
        repository.deleteById(id);
    }
}
