package com.springprofissional.dscommerce.repositories;

import com.springprofissional.dscommerce.entities.Order;
import org.springframework.data.jpa.repository.JpaRepository;

public interface OrderRepository extends JpaRepository<Order,Long> {
}
