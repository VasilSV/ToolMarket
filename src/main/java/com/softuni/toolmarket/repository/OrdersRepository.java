package com.softuni.toolmarket.repository;

import com.softuni.toolmarket.model.entity.OrdersEntity;

import com.softuni.toolmarket.model.enums.OrderedProductName;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;


import java.util.List;
import java.util.Optional;

@Repository

public interface OrdersRepository extends JpaRepository<OrdersEntity, Long> {

   // Optional<OrdersEntity> findOrdersEntityByProductName_AndProductName(OrderedProductName productName);
@Query("SELECT o.productName FROM OrdersEntity o")
    String findTotalOrders();

//List<OrdersEntity> findAllByToolsOrderStartingWithAndProductName(OrderedProductName productName);
}
