package com.springprofissional.dscommerce.services;


import com.springprofissional.dscommerce.dto.OrderDTO;
import com.springprofissional.dscommerce.dto.OrderItemDTO;
import com.springprofissional.dscommerce.dto.ProductDTO;
import com.springprofissional.dscommerce.entities.*;
import com.springprofissional.dscommerce.repositories.OrderItemRepository;
import com.springprofissional.dscommerce.repositories.OrderRepository;
import com.springprofissional.dscommerce.repositories.ProductRepository;
import com.springprofissional.dscommerce.services.exceptions.ResourceNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.time.Instant;

@Service
public class OrderService {

    @Autowired
    private OrderRepository repository;

    @Autowired
    private UserService userService;

    @Autowired
    private ProductRepository productRepository;

    @Autowired
    private OrderItemRepository orderItemRepository;

    @Autowired
    private AuthService authService;

    @Transactional(readOnly = true)
    public OrderDTO findById(Long id){
        Order order = repository.findById(id).orElseThrow(() -> new ResourceNotFoundException("Recurso nao encontrado"));
        authService.validateSelfOrAdmin(order.getClient().getId());
        return new OrderDTO(order);
    }

    @Transactional(readOnly = true)
    public OrderDTO insert(OrderDTO dto) {
        Order order = new Order();

        order.setMoment(Instant.now());
        order.setStatus(OrderStatus.WAITING_PAYMENT);

        //OBTENDO UM USUARIO PARA CRIAR UM PEDIDO ATRAVES DO USER SERVICE
        User user = userService.authenticated();

        order.setClient(user); //SETA O USUARIO LOGADO

        for(OrderItemDTO item : dto.getItems()){
            Product product = productRepository.getReferenceById(item.getProductId()); //pega o product com o id
            OrderItem items = new OrderItem(order, product,item.getQuantity(),product.getPrice());
            order.getItems().add(items);
        }

        repository.save(order);
        orderItemRepository.saveAll(order.getItems());

        return new OrderDTO(order);
    }
}
