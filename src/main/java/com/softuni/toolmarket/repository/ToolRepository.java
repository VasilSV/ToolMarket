package com.softuni.toolmarket.repository;

import com.softuni.toolmarket.model.entity.ToolEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ToolRepository extends JpaRepository <ToolEntity, Long> {
}
