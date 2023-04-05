package com.softuni.toolmarket.service.impl;

import com.softuni.toolmarket.model.entity.OrdersEntity;
import com.softuni.toolmarket.model.enums.OrderedProductName;
import com.softuni.toolmarket.repository.OrdersRepository;
import com.softuni.toolmarket.service.OrderService;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

@Service
public class OrderServiceImpl implements OrderService {

    private final OrdersRepository ordersRepository;
    private final ModelMapper modelMapper;


    public OrderServiceImpl(OrdersRepository ordersRepository, ModelMapper modelMapper) {
        this.ordersRepository = ordersRepository;
        this.modelMapper = modelMapper;
    }

   @Override
    public void add(OrderServiceImpl orderServiceImpl) {
       OrdersEntity ordersEntity= modelMapper.map(orderServiceImpl, OrdersEntity.class);
//ordersEntity.setProductName(findOrdersEntityByProductName_AndProductName();
    }

    @Override
    public OrdersEntity findOrdersEntityByProductName_AndProductName(OrderedProductName productName) {
        return null;
    }

    @Override
    public String getTotalOrders() {
        return ordersRepository.findTotalOrders();
    }


    // @Override
  //  public OrdersEntity findOrdersEntityByProductName_AndProductName(OrderedProductName productName) {
       // return ordersRepository.findOrdersEntityByProductName_AndProductName(productName)
             //   .orElse(null);
   // }
}
