package com.softuni.toolmarket.model.entity;

import jakarta.persistence.*;

@Table(name = "tools")
@Entity
public class ToolEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long Id;
    @Column(nullable = false)
    private String toolName;
    @Column(columnDefinition = "text")
    private String description;

    @ManyToOne
    private UserEntity userName;
    @ManyToOne
    private ToolTypeEntity toolTypeEntity;

    public ToolEntity() {
    }

    public Long getId() {
        return Id;
    }

    public ToolEntity setId(Long id) {
        Id = id;
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

    @Override
    public String toString() {
        return "ToolEntity{" +
                "Id=" + Id +
                ", toolName='" + toolName + '\'' +
                ", description='" + description + '\'' +
                ", userName=" + (userName != null ? userName.getUserName() : null) +
                ", toolType=" + toolTypeEntity +
                '}';
    }
}
