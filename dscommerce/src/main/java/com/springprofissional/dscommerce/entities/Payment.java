package com.springprofissional.dscommerce.entities;

import jakarta.persistence.*;

import java.time.Instant;

@Entity //Mapeando minha classe como entidade do meu projeto
@Table(name = "tb_payment") //Anotation permite que eu modifique o nome desta tabela user no banco de dados
public class Payment {

    @Id //Anotation indicando que o atributo abaixo é uma chave primaria da minha entidade
    @GeneratedValue(strategy = GenerationType.IDENTITY) //Colocado para que o ID seja autoincrementado no banco e nao surja IDS iguais.
    private Long id;
    @Column(columnDefinition = "TIMESTAMP WITHOUT TIME ZONE") //Gravando instant no banco sem time zone definido no caso ele puxa o UTC que é fuso de Londres padrao
    private Instant moment;

    @OneToOne //Um pagamento obrigatoriamente tem um pedido
    @MapsId //Mapeando as chaves primarias e estrageiras quer dizer que o pedido 5 vai ter a chave id de pagamento 5 as duas vao ser iguais
    private Order order;

    public Payment(){

    }

    public Payment(Long id, Instant moment, Order order) {
        this.id = id;
        this.moment = moment;
        this.order = order;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Instant getMoment() {
        return moment;
    }

    public void setMoment(Instant moment) {
        this.moment = moment;
    }

    public Order getOrder() {
        return order;
    }

    public void setOrder(Order order) {
        this.order = order;
    }
}
