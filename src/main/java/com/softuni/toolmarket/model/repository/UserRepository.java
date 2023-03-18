package com.softuni.toolmarket.model.repository;

import com.softuni.toolmarket.model.entity.UserEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<UserEntity, Long> {

}
