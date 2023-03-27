package com.softuni.toolmarket.model.dto;

public class ToolsDTO {

    private Long Id;

    private String toolName;

    private String description;

    private UserRegistrationDTO userRegister;

    public ToolsDTO() {
    }

    public Long getId() {
        return Id;
    }

    public ToolsDTO setId(Long id) {
        Id = id;
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
}
