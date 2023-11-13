package com.springprofissional.componentesSpring.services;

import org.springframework.stereotype.Service;

@Service
public class PensionService {

    public Double discount(double amount){
        return amount * 0.1;
    }
}
