package com.softuni.toolmarket.model.entity;

import jakarta.persistence.*;

import java.util.List;

@Entity
@Table(name = "type")
public class ToolTypeEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long Id;
    @Column(nullable = false)
    private String toolTypeName;

    @OneToMany(mappedBy = "toolTypeEntity")
    private List<ToolEntity> toolEntityList;

    public ToolTypeEntity() {
    }

    public Long getId() {
        return Id;
    }

    public ToolTypeEntity setId(Long id) {
        Id = id;
        return this;
    }

    public String getToolTypeName() {
        return toolTypeName;
    }

    public ToolTypeEntity setToolTypeName(String toolTypeName) {
        this.toolTypeName = toolTypeName;
        return this;
    }

    public List<ToolEntity> getToolEntityList() {
        return toolEntityList;
    }

    public ToolTypeEntity setToolEntityList(List<ToolEntity> toolEntityList) {
        this.toolEntityList = toolEntityList;
        return this;
    }

    @Override
    public String toString() {
        return "ToolType{" +
                "Id=" + Id +
                ", toolTypeName='" + toolTypeName + '\'' +
                ", toolEntityList=" + toolEntityList +
                '}';
    }
}
