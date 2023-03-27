package com.softuni.toolmarket.model.dto;

public class ToolTypeDTO {

    private String toolTypeName;

    public String getToolTypeName() {
        return toolTypeName;
    }

    public ToolTypeDTO setToolTypeName(String toolTypeName) {
        this.toolTypeName = toolTypeName;
        return this;
    }


    @Override
    public String toString() {
        return "ToolTypeDTO{" +
                "toolTypeName='" + toolTypeName + '\'' +
                '}';
    }
}
