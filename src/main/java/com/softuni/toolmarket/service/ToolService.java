package com.softuni.toolmarket.service;

import com.softuni.toolmarket.model.dto.ToolTypeDTO;
import com.softuni.toolmarket.model.dto.ToolsDTO;
import com.softuni.toolmarket.model.dto.UserRegistrationDTO;
import com.softuni.toolmarket.model.entity.ToolEntity;
import com.softuni.toolmarket.model.entity.ToolTypeEntity;
import com.softuni.toolmarket.repository.ToolRepository;
import com.softuni.toolmarket.repository.ToolTypeRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ToolService {

    private final ToolRepository toolRepository;

    private  final ToolTypeRepository toolTypeRepository;


    public ToolService(ToolRepository toolRepository, ToolTypeRepository toolTypeRepository) {
        this.toolRepository = toolRepository;
        this.toolTypeRepository = toolTypeRepository;
    }


    public Optional<ToolsDTO> findToolById(Long toolId) {
        return toolRepository
                .findById(toolId)
                .map(this::map);
    }

    public long createTool(ToolsDTO newTool) {

        String thisToolTypeName = newTool.getToolTypeEntity().getToolTypeName();
        Optional<ToolTypeEntity> toolTypeOpt=
                this.toolTypeRepository.findToolTypeEntityByToolTypeName(thisToolTypeName);

        ToolEntity newToolEntity = new ToolEntity()
                .setToolName(newTool.getToolName())
                .setToolType(toolTypeOpt.orElseGet(() -> createNewToolType(thisToolTypeName)));


        return toolRepository.save(newToolEntity).getId();
    }
    private ToolTypeEntity createNewToolType (String thisToolTypeName){
        return toolTypeRepository.save(new ToolTypeEntity().setToolTypeName(thisToolTypeName));
    }

    public  void deleteById(Long toolId) {
        toolRepository.findById(toolId)
               .ifPresent(toolRepository::delete);
    }
    public List<ToolsDTO> getAllTools() {
        return
                toolRepository.findAll().stream().map(this::map).toList();

    }

    private ToolsDTO map (ToolEntity toolEntity){
        ToolTypeDTO toolTypeDTO = new ToolTypeDTO()
                .setToolTypeName(toolEntity.getToolType().getToolTypeName());

        return new ToolsDTO().setId(toolEntity.getId())
                .setToolTypeEntity(toolTypeDTO)
                .setDescription(toolEntity.getDescription());


    }
}
