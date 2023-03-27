package com.softuni.toolmarket;

import com.softuni.toolmarket.model.entity.ToolEntity;
import com.softuni.toolmarket.repository.ToolRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
public class ToolMarketApplicationInit implements CommandLineRunner {

    private final ToolRepository toolRepository;

    public ToolMarketApplicationInit(ToolRepository toolRepository) {
        this.toolRepository = toolRepository;
    }

    @Override
    public void run(String... args) throws Exception {
        if (toolRepository.count()==0){
            initGardenTools();
        }
    }
    private void initGardenTools(){
        initTools("Coser","shame","soko");
    }

private void initTools(String ... toolName ){
    ToolEntity tool = new ToolEntity();
    tool.setToolName(String.valueOf(toolName));
    tool=toolRepository.save(tool);

    List<ToolEntity> allTools= new ArrayList<>();
    allTools.stream().map(tools -> new ToolEntity()).map(aTool -> {
        return allTools.stream().toList();
    }).forEach(toolRepository::saveAll);

}



}
