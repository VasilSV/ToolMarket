package com.softuni.toolmarket.model.dto;

import com.softuni.toolmarket.model.entity.ToolEntity;
import com.softuni.toolmarket.model.enums.OrderedProductName;

import javax.validation.constraints.FutureOrPresent;
import java.time.LocalDate;
import java.util.List;

public class OrdersDTO {

    private Long id;

    private String quantity;
    @FutureOrPresent(message = "Impossible performance")
    private LocalDate orderTime;

    private OrderedProductName productName;

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

    public LocalDate getOrderTime() {
        return orderTime;
    }

    public OrdersDTO setOrderTime(LocalDate orderTime) {
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

    public OrderedProductName getProductName() {
        return productName;
    }

    public OrdersDTO setProductName(OrderedProductName productName) {
        this.productName = productName;
        return this;
    }

    @Override
    public String toString() {
        return "OrdersDTO{" +
                "id=" + id +
                ", quantity='" + quantity + '\'' +
                ", orderTime='" + orderTime + '\'' +
                ", productName=" + productName +
                ", toolsOrders=" + toolsOrders +
                '}';
    }
}
