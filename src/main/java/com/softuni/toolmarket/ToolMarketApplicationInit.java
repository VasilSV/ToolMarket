package com.softuni.toolmarket;

import com.softuni.toolmarket.model.entity.ToolEntity;
import com.softuni.toolmarket.model.entity.ToolTypeEntity;
import com.softuni.toolmarket.repository.OrdersRepository;
import com.softuni.toolmarket.repository.ToolRepository;
import com.softuni.toolmarket.repository.ToolTypeRepository;
import com.softuni.toolmarket.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
public class ToolMarketApplicationInit implements CommandLineRunner {

    private final ToolRepository toolRepository;
    private final ToolTypeRepository toolTypeRepository;
    private final UserRepository userRepository;
    private final OrdersRepository ordersRepository;
@Autowired
    public ToolMarketApplicationInit(ToolRepository toolRepository, ToolTypeRepository toolTypeRepository,
                                     UserRepository userRepository,
                                     OrdersRepository ordersRepository) {
        this.toolRepository = toolRepository;
        this.toolTypeRepository = toolTypeRepository;

        this.userRepository = userRepository;
        this.ordersRepository = ordersRepository;
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


        aTool.setToolType(toolType);
        aTool.setToolName(toolName);
        aTool.setDescription(description);
        //aTool.setId(toolType.getToolEntityList().get());
        allTools.add(aTool);

        toolType.setToolEntityList(allTools);
        toolTypeRepository.save(toolType);
        toolRepository.saveAll(allTools);
    }





}
