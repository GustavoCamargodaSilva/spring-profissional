package com.springprofissional.dscommerce.repositories;

import com.springprofissional.dscommerce.entities.Product;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ProductRepository extends JpaRepository <Product,Long> { //essa camada é a camada que permite acesso a dados do programa
                                                                            //Product tipo da entidade e long é o tipo do ID de produto
}
