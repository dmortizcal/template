package com.dmortizcal.template.repository;

import com.dmortizcal.template.entity.UsersEntity;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface UsersRepository extends JpaRepository<UsersEntity, String> {
    Boolean existsByUseEmail(String email);
    Optional<UsersEntity> findByUseName(String name);
}
