package com.softuni.toolmarket.model.dto;

import com.softuni.toolmarket.model.entity.ToolTypeEntity;

public class ToolsDTO {

    private Long id;

    private String toolName;

    private String description;

    private UserRegistrationDTO userRegister;

    private ToolTypeDTO toolTypeEntity;

    public ToolsDTO() {
    }

    public Long getId() {
        return id;
    }

    public ToolsDTO setId(Long id) {
        id = id;
        return this;
    }

    public String getToolName() {
        return toolName;
    }

    public ToolsDTO setToolName(String toolName) {
        this.toolName = toolName;
        return this;
    }

    public String getDescription() {
        return description;
    }

    public ToolsDTO setDescription(String description) {
        this.description = description;
        return this;
    }

    public UserRegistrationDTO getUserRegister() {
        return userRegister;
    }

    public ToolsDTO setUserRegister(UserRegistrationDTO userRegister) {
        this.userRegister = userRegister;
        return this;
    }

    public ToolTypeDTO getToolTypeEntity() {
        return toolTypeEntity;
    }

    public ToolsDTO setToolTypeEntity(ToolTypeDTO toolTypeEntity) {
        this.toolTypeEntity = toolTypeEntity;
        return this;
    }

    @Override
    public String toString() {
        return "ToolsDTO{" +
                "id=" + id +
                ", toolName='" + toolName + '\'' +
                ", description='" + description + '\'' +
                ", userRegister=" + userRegister +
                ", toolTypeEntity=" + toolTypeEntity +
                '}';
    }
}
