package com.springprofissional.desafioComponentes.services;

import com.springprofissional.desafioComponentes.entities.Order;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ShippingService {

    public Double shipment(Order order){
        double basicValue = order.getBasic();

        if(basicValue < 100) {
            return 20.0;
        } else if (basicValue < 200) {
            return 12.0;
        }else{
            return 0.0;
        }
    }
}
