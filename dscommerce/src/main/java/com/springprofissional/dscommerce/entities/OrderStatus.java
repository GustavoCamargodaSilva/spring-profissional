package com.springprofissional.dscommerce.entities;

public enum OrderStatus { //Enum de Order mas esta no pacote incorreto

    WAITING_PAYMENT,    //AGUARDANDO PAGAMENTO PALAVRAS SEPARADAS USA UNDERLINE
    PAID,
    SHIPPED,
    DELIVERED,
    CANCELED;
}
