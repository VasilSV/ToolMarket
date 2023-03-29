package com.softuni.toolmarket;

import com.softuni.toolmarket.model.dto.ToolsDTO;
import com.softuni.toolmarket.model.entity.ToolEntity;
import com.softuni.toolmarket.model.entity.ToolTypeEntity;
import com.softuni.toolmarket.repository.ToolRepository;
import com.softuni.toolmarket.repository.ToolTypeRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

import java.util.ArrayList;
import java.util.List;

@Component
public class ToolMarketApplicationInit implements CommandLineRunner {

    private final ToolRepository toolRepository;
    private final ToolTypeRepository toolTypeRepository;

    public ToolMarketApplicationInit(ToolRepository toolRepository, ToolTypeRepository toolTypeRepository, RestTemplate restTemplate) {
        this.toolRepository = toolRepository;
        this.toolTypeRepository = toolTypeRepository;

    }

    @Override
    public void run(String... args) throws Exception {

        if (toolRepository.count() == 0 && toolTypeRepository.count() == 0) {
            initGardenTools();
            initHandTools();
            initEquipment();

        }
    }

    private void initGardenTools() {
        initToolType("Garden", "Coser", "Shovel");
    }

    private void initHandTools() {
        initToolType("HandTools", "Hammer", "Magnetic Hammer");
    }

    private void initEquipment(){
        initToolType("Equipment","Gloves","Helmet");
    }

    private void initToolType(String toolTypeName, String... tools) {
        ToolTypeEntity toolType = new ToolTypeEntity();
        toolType.setToolTypeName(toolTypeName);
        toolType = toolTypeRepository.save(toolType);

        List<ToolEntity> allTools = new ArrayList<>();

        for (String tool : tools) {
            ToolEntity aTool = new ToolEntity();
            aTool.setToolType(toolType);
            aTool.setToolName(tool);

            allTools.add(aTool);
        }
        toolType.setToolEntityList(allTools);
        toolTypeRepository.save(toolType);
        toolRepository.saveAll(allTools);
    }





}
