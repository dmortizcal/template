package com.dmortizcal.template.service;

import com.dmortizcal.template.entity.UsersEntity;
import com.dmortizcal.template.repository.UsersRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;

import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
class UsersServiceTest {

    @Autowired
    private UsersService usersService;

    @MockBean
    private UsersRepository usersRepository;

    @BeforeEach
    void setUp() {
        UsersEntity userEntity = UsersEntity.builder()
                .useId(1L)
                .useEmail("dmortizcal@gmail.com")
                .useName("Mario")
                .build();

        Mockito.when(usersRepository.findByUseName("Mario")).thenReturn(Optional.of(userEntity));
    }

    @Test
    @DisplayName("Prueba de obtención de información de un usuario enviando un nombre válido")
    public void findByName(){
        String localName = "Mario";
        UsersEntity userEntity = usersService.findByName(localName).get();
        assertEquals(localName,userEntity.getUseName());
        System.out.println("Usuario = " + userEntity);
    }
}