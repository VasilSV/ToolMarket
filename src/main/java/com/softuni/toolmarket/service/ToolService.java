package com.softuni.toolmarket.service;

import com.softuni.toolmarket.model.dto.ToolTypeDTO;
import com.softuni.toolmarket.model.dto.ToolsDTO;

import com.softuni.toolmarket.model.entity.ToolEntity;
import com.softuni.toolmarket.model.entity.ToolTypeEntity;

import com.softuni.toolmarket.repository.ToolRepository;
import com.softuni.toolmarket.repository.ToolTypeRepository;
import com.softuni.toolmarket.repository.UserRepository;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class ToolService {

    private final ToolRepository toolRepository;

    private final ToolTypeRepository toolTypeRepository;
    private final UserRepository userRepository;
    private final ModelMapper modelMapper;

    public ToolService(ToolRepository toolRepository, ToolTypeRepository toolTypeRepository,
                       UserRepository userRepository, ModelMapper modelMapper) {
        this.toolRepository = toolRepository;
        this.toolTypeRepository = toolTypeRepository;
        this.userRepository = userRepository;
        this.modelMapper = modelMapper;
    }


    public Optional<ToolsDTO> findToolById(Long toolId) {
        return toolRepository
                .findById(toolId)
                .stream()
                .map(toolEntity -> modelMapper.map(toolEntity, ToolsDTO.class))
                .findFirst();

    }

    public long createTool(ToolsDTO newTool) {

        String thisToolTypeName = newTool.getToolTypeEntity().getToolTypeName();
        Optional<ToolTypeEntity> toolTypeOpt =
                this.toolTypeRepository.findToolTypeEntityByToolTypeName(thisToolTypeName);

        ToolEntity newToolEntity = new ToolEntity();

        newToolEntity.setToolTypeEntity
                (toolTypeOpt.orElseGet(() -> createNewToolType(thisToolTypeName)));

        newToolEntity.setDescription(newTool.getDescription());
        

      //  newToolEntity.setToolName(newTool.getToolName()).
        //setToolType(toolTypeOpt.orElseGet(() -> createNewToolType(thisToolTypeName)));
        //newToolEntity.setId(newTool.getId());

        return toolRepository.save(newToolEntity).getId();
    }

    private ToolTypeEntity createNewToolType(String thisToolTypeName) {
        return toolTypeRepository.save(createNewToolType(thisToolTypeName));
    }

    public void deleteById(Long toolId) {
        toolRepository.findById(toolId)
                .ifPresent(toolRepository::delete);
    }

    public List<ToolsDTO> getAllTools() {
        return
                toolRepository.findAll().stream()
                        .map(toolEntity -> modelMapper.map(toolEntity, ToolsDTO.class))
                        .collect(Collectors.toList());

    }
}


