package com.springprofissional.desafioComponentes.services;

import com.springprofissional.desafioComponentes.entities.Order;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class OrderService {

    @Autowired
    private ShippingService ship;

    public OrderService(ShippingService ship) {
        this.ship = ship;
    }

    public Double total(Order order){
       return order.getBasic() - (order.getDiscount() / 100 * order.getBasic()) + ship.shipment(order);
    }
}
