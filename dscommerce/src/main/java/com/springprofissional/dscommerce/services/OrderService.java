package com.springprofissional.dscommerce.services;


import com.springprofissional.dscommerce.dto.OrderDTO;
import com.springprofissional.dscommerce.dto.ProductDTO;
import com.springprofissional.dscommerce.entities.Order;
import com.springprofissional.dscommerce.entities.Product;
import com.springprofissional.dscommerce.repositories.OrderRepository;
import com.springprofissional.dscommerce.services.exceptions.ResourceNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class OrderService {

    @Autowired
    OrderRepository repository;

    @Transactional(readOnly = true)
    public OrderDTO findById(Long id){
        Order order = repository.findById(id).orElseThrow(() -> new ResourceNotFoundException("Recurso nao encontrado"));
        return new OrderDTO(order);
    }
}
