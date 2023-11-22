package com.springprofissional.dscommerce.entities;

import jakarta.persistence.*;

import java.util.HashSet;
import java.util.List;
import java.util.Objects;
import java.util.Set;

@Entity //Mapeando minha classe como entidade do meu projeto
@Table(name = "tb_product") //Anotation permite que eu modifique o nome desta tabela user no banco de dados
public class Product {

    @Id //Anotation indicando que o atributo abaixo é uma chave primaria da minha entidade
    @GeneratedValue(strategy = GenerationType.IDENTITY) //Colocado para que o ID seja autoincrementado no banco e nao surja IDS iguais.
    private Long id;
    private String name;
    @Column(columnDefinition = "TEXT")//Colocando que essa descricao vai ser um texto e nao um var char de 255 comum
    private String description;
    private Double price;
    private String imgUrl;

    @ManyToMany //Muitos para muitos
    @JoinTable(name = "tb_product_category", //Tabela de junçao
            joinColumns = @JoinColumn(name = "product_id"), //Referencia para as duas chaves estrangeiras
            inverseJoinColumns = @JoinColumn(name = "category_id"))
    private Set<Category> categories = new HashSet<>(); //Set pois os IDS nao podem se repetir o par produto e categoria ID

    @OneToMany(mappedBy = "id.product")
    private Set<OrderItem>items = new HashSet<>();

    public Product(){

    }

    public Product(Long id, String name, String description, Double price, String imgUrl) {
        this.id = id;
        this.name = name;
        this.description = description;
        this.price = price;
        this.imgUrl = imgUrl;
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

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Double getPrice() {
        return price;
    }

    public void setPrice(Double price) {
        this.price = price;
    }

    public String getImgUrl() {
        return imgUrl;
    }

    public void setImgUrl(String imgUrl) {
        this.imgUrl = imgUrl;
    }

    public Set<Category> getCategories() {
        return categories;
    }

    public Set<OrderItem> getItems() {
        return items;
    }

    public List<Order> getOrders() {
        return items.stream().map(x -> x.getOrder()).toList();
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Product product)) return false;

        return Objects.equals(id, product.id);
    }

    @Override
    public int hashCode() {
        return id != null ? id.hashCode() : 0;
    }
}
