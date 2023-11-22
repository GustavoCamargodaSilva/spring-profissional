package com.springprofissional.dscommerce.entities;

import jakarta.persistence.*;

import java.util.HashSet;
import java.util.Objects;
import java.util.Set;

@Entity //Mapeando minha classe como entidade do meu projeto
@Table(name = "tb_category") //Anotation permite que eu modifique o nome desta tabela user no banco de dados
public class Category {

    @Id //Anotation indicando que o atributo abaixo é uma chave primaria da minha entidade
    @GeneratedValue(strategy = GenerationType.IDENTITY) //Colocado para que o ID seja autoincrementado no banco e nao surja IDS iguais.
    private Long id;
    private String name;

    @ManyToMany(mappedBy = "categories") //Mapeado usando o nome do atributo em product
    private Set<Product> products = new HashSet<>();

    public Category(){

    }

    public Category(Long id, String name) {
        this.id = id;
        this.name = name;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Set<Product> getProducts() {
        return products;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Category category)) return false;

        return Objects.equals(id, category.id);
    }

    @Override
    public int hashCode() {
        return id != null ? id.hashCode() : 0;
    }
}
