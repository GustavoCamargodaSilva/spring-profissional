package com.springprofissional.dscommerce.entities;

import jakarta.persistence.*;
import java.time.Instant;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

@Entity //Mapeando minha classe como entidade do meu projeto
@Table(name = "tb_order") //Anotation permite que eu modifique o nome desta tabela user no banco de dados
public class Order {

    @Id //Anotation indicando que o atributo abaixo é uma chave primaria da minha entidade
    @GeneratedValue(strategy = GenerationType.IDENTITY) //Colocado para que o ID seja autoincrementado no banco e nao surja IDS iguais.
    private Long id;

    @Column(columnDefinition = "TIMESTAMP WITHOUT TIME ZONE") //Gravando instant no banco sem time zone definido no caso ele puxa o UTC que é fuso de Londres padrao
    private Instant moment;
    private OrderStatus status;


    @ManyToOne //Relacionamento muitos para um
    @JoinColumn(name = "client_id")//nome da chave estrageira que recebe no banco nome deve respeitar o nome abaixo que está no diagrama
    private User client; //nome que veio do relacionamento no diagrama

    @OneToOne(mappedBy = "order", cascade = CascadeType.ALL) //Mapeado com o nome do atributo do relacionamento do outro lado
    private Payment payment; //Uma ordem tem um 0 ou 1 pagamento

    @OneToMany(mappedBy = "id.order")
    private Set<OrderItem> items = new HashSet<>();

    public Order (){

    }

    public Order(Long id, Instant moment, OrderStatus status, User client, Payment payment) {
        this.id = id;
        this.moment = moment;
        this.status = status;
        this.client = client;
        this.payment = payment;
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

    public OrderStatus getStatus() {
        return status;
    }

    public void setStatus(OrderStatus status) {
        this.status = status;
    }

    public User getClient() {
        return client;
    }

    public void setClient(User client) {
        this.client = client;
    }

    public Payment getPayment() {
        return payment;
    }

    public void setPayment(Payment payment) {
        this.payment = payment;
    }

    public Set<OrderItem> getItems() {
        return items;
    }

    public List<Product> getProducts() {
        return items.stream().map(x -> x.getProduct()).toList();
    }

}
