package com.springprofissional.dscommerce.repositories;

import com.springprofissional.dscommerce.entities.Order;
import com.springprofissional.dscommerce.entities.OrderItem;
import com.springprofissional.dscommerce.entities.OrderItemPK;
import org.springframework.data.jpa.repository.JpaRepository;

public interface OrderItemRepository extends JpaRepository<OrderItem, OrderItemPK> {

}
