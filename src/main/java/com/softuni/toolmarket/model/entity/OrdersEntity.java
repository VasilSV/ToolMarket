package com.softuni.toolmarket.model.entity;

import jakarta.persistence.*;

import java.util.List;

@Entity
@Table(name = "orders")
public class OrdersEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(nullable = false)
    private String Quantity;
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
        return Quantity;
    }

    public OrdersEntity setQuantity(String quantity) {
        Quantity = quantity;
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
}
