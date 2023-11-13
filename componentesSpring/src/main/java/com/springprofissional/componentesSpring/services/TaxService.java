package com.springprofissional.componentesSpring.services;

import org.springframework.stereotype.Service;

@Service   //registrado no spring como componente/serviço
public class TaxService {

    public Double tax(double amount) {
        return amount * 0.2;
    }

}
