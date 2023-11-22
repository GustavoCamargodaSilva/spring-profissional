package com.springprofissional.dscommerce.entities;

import jakarta.persistence.Embeddable;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;

@Embeddable
public class OrderItemPK { //Classe criada para referenciar as chaves estrageiras no relacionamento

        @ManyToOne //muitos para um
        @JoinColumn(name = "order_id")//mapeados como chave estrageira
        private Order order;
        @ManyToOne
        @JoinColumn(name = "product_id")
        private Product product;

        public OrderItemPK(){

        }

    public OrderItemPK(Order order, Product product) {
        this.order = order;
        this.product = product;
    }

    public Order getOrder() {
        return order;
    }

    public void setOrder(Order order) {
        this.order = order;
    }

    public Product getProduct() {
        return product;
    }

    public void setProduct(Product product) {
        this.product = product;
    }
}
