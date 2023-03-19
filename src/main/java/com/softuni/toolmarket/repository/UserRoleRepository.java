package com.softuni.toolmarket.repository;

import com.softuni.toolmarket.model.entity.UserRoleEntity;
import com.softuni.toolmarket.model.enums.UserRoleEnum;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface UserRoleRepository extends JpaRepository<UserRoleEntity, Long> {
    Optional<UserRoleEntity> findByRole(UserRoleEnum role);

}
