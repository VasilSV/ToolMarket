package com.softuni.toolmarket;

import com.softuni.toolmarket.model.entity.ToolEntity;
import com.softuni.toolmarket.model.entity.ToolTypeEntity;
import com.softuni.toolmarket.repository.ToolRepository;
import com.softuni.toolmarket.repository.ToolTypeRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
public class ToolMarketApplicationInit implements CommandLineRunner {

    private final ToolRepository toolRepository;
    private final ToolTypeRepository toolTypeRepository;

    public ToolMarketApplicationInit(ToolRepository toolRepository, ToolTypeRepository toolTypeRepository) {
        this.toolRepository = toolRepository;
        this.toolTypeRepository = toolTypeRepository;

    }

    @Override
    public void run(String... args) throws Exception {

        if (toolRepository.count() == 0 && toolTypeRepository.count() == 0) {
            initGardenTools();
            initGardenTools2();
            initHandTools();
            initHandTools2();
            initEquipment();
            initEquipment2();

        }
    }

    private void initGardenTools() {
        initToolType("Garden", "jdjdjd", "Coser");
    }
    private void initGardenTools2() {
        initToolType("Garden", "Shovwedwdwel", "Shovel");
    }

    private void initHandTools() {
        initToolType("HandTools", "fsdfs", "Magnetic Hammer");
    }
    private void initHandTools2() {
        initToolType("HandTools", "sdfsdsdf", " Hammer" );
    }

    private void initEquipment(){
        initToolType("Equipment","ssssd","Helmet");
    }

    private void initEquipment2(){
        initToolType("Equipment","dsdaaaad","Gloves");
    }
    private void initToolType(String toolTypeName, String description, String toolName) {
        ToolTypeEntity toolType = new ToolTypeEntity();
        toolType.setToolTypeName(toolTypeName);
        toolType = toolTypeRepository.save(toolType);

        List<ToolEntity> allTools = new ArrayList<>();


        ToolEntity aTool = new ToolEntity();
        aTool.setId(aTool.getId());
        aTool.setToolName(toolName);
        aTool.setDescription(description);
        allTools.add(aTool);

        toolType.setToolEntityList(allTools);
        toolTypeRepository.save(toolType);
        toolRepository.saveAll(allTools);
    }





}
