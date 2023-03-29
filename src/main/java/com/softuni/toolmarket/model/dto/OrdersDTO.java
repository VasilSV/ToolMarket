package com.softuni.toolmarket.model.dto;

import com.softuni.toolmarket.model.entity.ToolEntity;

import java.util.List;

public class OrdersDTO {

    private Long id;

    private String quantity;

    private String orderTime;

    private List<ToolEntity> toolsOrders;

    public OrdersDTO() {
    }

    public Long getId() {
        return id;
    }

    public OrdersDTO setId(Long id) {
        this.id = id;
        return this;
    }

    public String getQuantity() {
        return quantity;
    }

    public OrdersDTO setQuantity(String quantity) {
        this.quantity = quantity;
        return this;
    }

    public String getOrderTime() {
        return orderTime;
    }

    public OrdersDTO setOrderTime(String orderTime) {
        this.orderTime = orderTime;
        return this;
    }

    public List<ToolEntity> getToolsOrders() {
        return toolsOrders;
    }

    public OrdersDTO setToolsOrders(List<ToolEntity> toolsOrders) {
        this.toolsOrders = toolsOrders;
        return this;
    }
}
