package com.softuni.toolmarket.repository;

import com.softuni.toolmarket.model.entity.OrdersEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface OrdersRepository extends JpaRepository<OrdersEntity, Long> {
}
