package com.softuni.toolmarket.web;

import com.softuni.toolmarket.model.dto.ToolsDTO;
import com.softuni.toolmarket.service.ToolService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.util.UriComponentsBuilder;

import java.util.List;
import java.util.Optional;


@RestController
@RequestMapping("/api/tools")
public class ToolsController {

    private final ToolService toolService;

    public ToolsController(ToolService toolService) {
        this.toolService = toolService;
    }

    @GetMapping
    public ResponseEntity<List<ToolsDTO>> getAllTools() {
        return ResponseEntity.ok(toolService.getAllTools());

    }

    @GetMapping("/{id}")
    public ResponseEntity<ToolsDTO> getToolById(@PathVariable("id") Long toolId) {
        Optional<ToolsDTO> theTool = toolService.findToolById(toolId);

        return theTool.map(ResponseEntity::ok)
                .orElseGet(() -> ResponseEntity.notFound().build());

    }

    @DeleteMapping("/{id}")
    public ResponseEntity<ToolsDTO> deleteToolById(@PathVariable("id") Long toolId) {
        ToolService.deleteById(toolId);

        return ResponseEntity.
                noContent().
                build();
    }
    @PostMapping()
    public ResponseEntity<ToolsDTO> createTool(@RequestBody ToolsDTO newTool,
                                              UriComponentsBuilder uriComponentsBuilder) {
        long newToolId = toolService.createTool(newTool);

        return ResponseEntity.created(uriComponentsBuilder.
                        path("/api/tools/{id}").build(newToolId)).
                build();
    }


}
