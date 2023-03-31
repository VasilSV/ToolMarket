package com.softuni.toolmarket.repository;

import com.softuni.toolmarket.model.entity.ToolEntity;
import com.softuni.toolmarket.model.enums.OrderedProductName;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ToolRepository extends JpaRepository <ToolEntity, Long> {

}
