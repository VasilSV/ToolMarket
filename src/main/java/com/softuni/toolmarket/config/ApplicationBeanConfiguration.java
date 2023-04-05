package com.softuni.toolmarket.config;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import org.modelmapper.Converter;
import org.modelmapper.ModelMapper;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

@Configuration
public class ApplicationBeanConfiguration {

    @Bean
    public Gson gson() {
        return new GsonBuilder()
                .excludeFieldsWithoutExposeAnnotation()
                .setPrettyPrinting()
                .create();
    }
    @Bean
    public ModelMapper modelMapper() {
        ModelMapper modelMapper = new ModelMapper();
        Converter<String, LocalDate> toLocalDate = s -> s.getSource() == null ? null
                : LocalDate.parse((s.getSource()), DateTimeFormatter.ofPattern("dd/MM/yyyy"));
        modelMapper.addConverter(toLocalDate);


        return modelMapper;
    }



}
