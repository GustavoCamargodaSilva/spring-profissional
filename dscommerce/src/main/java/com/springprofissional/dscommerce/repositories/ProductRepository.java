package com.springprofissional.dscommerce.repositories;

import com.springprofissional.dscommerce.entities.Product;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

public interface ProductRepository extends JpaRepository <Product,Long> { //essa camada é a camada que permite acesso a dados do programa
                                                                            //Product tipo da entidade e long é o tipo do ID de produto

    @Query("SELECT obj FROM Product obj " +
            "WHERE UPPER(obj.name) LIKE UPPER(CONCAT('%', :name,'%'))")
    Page<Product> searchByName(String name, Pageable pageable);
}
