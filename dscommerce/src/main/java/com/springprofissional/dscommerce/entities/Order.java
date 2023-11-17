package com.springprofissional.dscommerce.entities;

import jakarta.persistence.*;
import java.time.Instant;

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
}
