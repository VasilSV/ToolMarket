package com.softuni.toolmarket.model.entity;

import com.softuni.toolmarket.model.dto.UserRegistrationDTO;
import com.softuni.toolmarket.repository.UserRepository;
import jakarta.persistence.*;

import java.util.List;

@Table(name = "tools")
@Entity
public class ToolEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(nullable = false, unique = true)
    private String toolName;
    @Column( columnDefinition = "text")
    private String description;

    @ManyToOne
    private UserEntity userName;
    @ManyToOne
    private ToolTypeEntity toolTypeEntity;
    @ManyToMany(mappedBy = "toolsOrder")
    private List<OrdersEntity> orderedTools;

    public ToolEntity() {
    }

    public Long getId() {
        return id;
    }

    public ToolEntity setId(Long id) {
        this.id = id;
        return this;
    }

    public String getToolName() {
        return toolName;
    }

    public ToolEntity setToolName(String toolName) {
        this.toolName = toolName;
        return this;
    }

    public String getDescription() {
        return description;
    }

    public ToolEntity setDescription(String description) {
        this.description = description;
        return this;
    }

    public UserEntity getUserName() {
        return userName;
    }

    public ToolEntity setUserName(UserEntity userName) {
        this.userName = userName;
        return this;
    }

    public ToolTypeEntity getToolType() {
        return toolTypeEntity;
    }

    public ToolEntity setToolType(ToolTypeEntity toolTypeEntity) {
        this.toolTypeEntity = toolTypeEntity;
        return this;
    }

    public ToolTypeEntity getToolTypeEntity() {
        return toolTypeEntity;
    }

    public ToolEntity setToolTypeEntity(ToolTypeEntity toolTypeEntity) {
        this.toolTypeEntity = toolTypeEntity;
        return this;
    }

    public List<OrdersEntity> getOrderedTools() {
        return orderedTools;
    }

    public ToolEntity setOrderedTools(List<OrdersEntity> orderedTools) {
        this.orderedTools = orderedTools;
        return this;
    }

    @Override
    public String toString() {
        return "ToolEntity{" +
                "id=" + id +
                ", toolName='" + toolName + '\'' +
                ", description='" + description + '\'' +
                ", userName=" + (userName != null ? userName.getUserName() : null) +
                ", toolTypeEntity=" + toolTypeEntity +
                ", orderedTools=" + orderedTools +
                '}';
    }


}
