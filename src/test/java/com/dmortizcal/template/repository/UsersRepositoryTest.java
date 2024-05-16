package com.dmortizcal.template.repository;


import com.dmortizcal.template.entity.UsersEntity;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.autoconfigure.orm.jpa.TestEntityManager;

import java.util.Optional;

import static org.junit.jupiter.api.Assertions.assertEquals;

@DataJpaTest
class UsersRepositoryTest {

    @Autowired
    UsersRepository userRepository;

    @Autowired
    TestEntityManager testEntityManager;

    @BeforeEach
    void setUp() {
        UsersEntity userEntity = UsersEntity.builder()
                .useId(1L)
                .useEmail("dmortizcal@gmail.com")
                .useName("Mario")
                .build();

        testEntityManager.persist(userEntity);
    }

    @Test
    public void existsByUseEmail() {
        boolean exists = userRepository.existsByUseEmail("dmortizcal@gmail.com");
        System.out.print(exists);
    }

    @Test
    public void findByName() {
        Optional<UsersEntity> user = userRepository.findByUseName("Mario");

        assertEquals(user.get().getUseName(), "Mario");
        System.out.println("Usuario = " + user.get());
    }
}