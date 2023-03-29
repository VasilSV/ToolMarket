package com.softuni.toolmarket.model.entity;

import jakarta.persistence.*;

import java.time.LocalDate;
import java.util.Date;
import java.util.List;

@Entity
@Table(name = "orders")
public class OrdersEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(nullable = false)
    private String quantity;
    @Column(nullable = false )
    private LocalDate orderTime;


    @ManyToOne
    private UserEntity client;
    @ManyToMany
    private List<ToolEntity> toolsOrder;

    public OrdersEntity() {
    }

    public Long getId() {
        return id;
    }

    public OrdersEntity setId(Long id) {
        this.id = id;
        return this;
    }

    public String getQuantity() {
        return quantity;
    }

    public OrdersEntity setQuantity(String quantity) {
        quantity = quantity;
        return this;
    }

    public UserEntity getClient() {
        return client;
    }

    public OrdersEntity setClient(UserEntity client) {
        this.client = client;
        return this;
    }

    public List<ToolEntity> getToolsOrder() {
        return toolsOrder;
    }

    public OrdersEntity setToolsOrder(List<ToolEntity> toolsOrder) {
        this.toolsOrder = toolsOrder;
        return this;
    }

    public LocalDate getOrderTime() {
        return orderTime;
    }

    public OrdersEntity setOrderTime(LocalDate orderTime) {
        this.orderTime = orderTime;
        return this;
    }

    @Override
    public String toString() {
        return "OrdersEntity{" +
                "id=" + id +
                ", quantity='" + quantity + '\'' +
                ", orderTime=" + orderTime +
                ", client=" + client +
                ", toolsOrder=" + toolsOrder +
                '}';
    }
}
