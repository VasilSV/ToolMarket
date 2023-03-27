package com.softuni.toolmarket.service;

import com.softuni.toolmarket.model.dto.ToolsDTO;
import com.softuni.toolmarket.model.dto.UserRegistrationDTO;
import com.softuni.toolmarket.model.entity.ToolEntity;
import com.softuni.toolmarket.repository.ToolRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ToolService {

    private final ToolRepository toolRepository;

    public ToolService(ToolRepository toolRepository) {
        this.toolRepository = toolRepository;
    }



    private ToolsDTO map(ToolEntity toolEntity) {
        UserRegistrationDTO userRegistrationDTO = new UserRegistrationDTO()
                .setUserName(toolEntity.getUserName().getUserName());
        return new ToolsDTO()
                .setId(toolEntity.getId())
                .setUserRegister(userRegistrationDTO)
                .setToolName(toolEntity.getToolName())
                .setDescription(toolEntity.getDescription());
    }

    public Optional<ToolsDTO> findToolById(Long toolId) {
        return toolRepository
                .findById(toolId)
                .map(this::map);
    }

    public long createTool(ToolsDTO newTool) {
        return 0;
    }

    public static void deleteById(Long toolId) {
      //  toolRepository.findById(toolId)
            //    .ifPresent(toolRepository::delete);
    }
    public List<ToolsDTO> getAllTools() {
        return
                toolRepository.findAll().stream().map(this::map).toList();

    }
}
