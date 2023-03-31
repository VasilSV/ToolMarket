package com.softuni.toolmarket.view;

public class ToolsViewModel {
    private Long id;
    private String toolName;
    private String description;

    public ToolsViewModel() {
    }

    public Long getId() {
        return id;
    }

    public ToolsViewModel setId(Long id) {
        this.id = id;
        return this;
    }

    public String getToolName() {
        return toolName;
    }

    public ToolsViewModel setToolName(String toolName) {
        this.toolName = toolName;
        return this;
    }

    public String getDescription() {
        return description;
    }

    public ToolsViewModel setDescription(String description) {
        this.description = description;
        return this;
    }
}
