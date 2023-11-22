package com.springprofissional.dscommerce.entities;

import jakarta.persistence.EmbeddedId;
import jakarta.persistence.Entity;
import jakarta.persistence.Table;

import java.util.Objects;

@Entity
@Table(name = "tb_order_item")
public class OrderItem {

    @EmbeddedId
    private OrderItemPK id = new OrderItemPK(); //precisa instanciar a chave estrangeira composta

    private Integer quantity;
    private Double price;

    public OrderItem () {

    }

    public OrderItem(Order order, Product product, Integer quantity, Double price) {//construtor nao deve ter referencia diretamente para OrderItemPk
        id.setOrder(order);                                                        //quando ele for instanciado vai dar set nos itens do meu idPK que esta
        id.setProduct(product);                                                    //Instanciado ali em cima e ele que é responsavel pelo relacionamento
        this.quantity = quantity;
        this.price = price;
    }

    public Order getOrder(){ //Obter o ID do item que está dentro de OrderItem colocado a mao
        return id.getOrder();
    }

    public Product getProduct(){ //Obter o ID do item que está dentro de OrderItem colocado a mao
        return id.getProduct();
    }

    public void setProduct(Product product){ //Setar um Order para o ID
        id.setProduct(product);
    }

    public void setOrder(Order order){ //Setar um Order para o ID
        id.setOrder(order);
    }

    public Integer getQuantity() {
        return quantity;
    }

    public void setQuantity(Integer quantity) {
        this.quantity = quantity;
    }

    public Double getPrice() {
        return price;
    }

    public void setPrice(Double price) {
        this.price = price;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof OrderItem orderItem)) return false;

        return Objects.equals(id, orderItem.id);
    }

    @Override
    public int hashCode() {
        return id != null ? id.hashCode() : 0;
    }
}
