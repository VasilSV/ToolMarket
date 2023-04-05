package com.softuni.toolmarket.service;

import com.softuni.toolmarket.model.entity.OrdersEntity;
import com.softuni.toolmarket.model.enums.OrderedProductName;
import com.softuni.toolmarket.service.impl.OrderServiceImpl;

public interface OrderService {


    void add(OrderServiceImpl orderServiceImpl);

    OrdersEntity findOrdersEntityByProductName_AndProductName (OrderedProductName productName);

    String getTotalOrders();
}
