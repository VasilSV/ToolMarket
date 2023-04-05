package com.softuni.toolmarket.model.dto;

public class ToolTypeDTO {
    private Long id;
    private String toolTypeName;

    public String getToolTypeName() {
        return toolTypeName;
    }

    public ToolTypeDTO setToolTypeName(String toolTypeName) {
        this.toolTypeName = toolTypeName;
        return this;
    }

    public Long getId() {
        return id;
    }

    public ToolTypeDTO setId(Long id) {
        this.id = id;
        return this;
    }

    public ToolTypeDTO() {
    }

    @Override
    public String toString() {
        return "ToolTypeDTO{" +
                "id=" + id +
                ", toolTypeName='" + toolTypeName + '\'' +
                '}';
    }
}
