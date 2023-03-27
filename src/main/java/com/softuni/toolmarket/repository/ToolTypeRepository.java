package com.softuni.toolmarket.repository;

import com.softuni.toolmarket.model.entity.ToolTypeEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface ToolTypeRepository extends JpaRepository<ToolTypeEntity, Long> {

    Optional<ToolTypeEntity> findToolTypeEntityByToolTypeName(String thisToolTypeName);

}
