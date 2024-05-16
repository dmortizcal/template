package com.dmortizcal.template.controller;

import com.dmortizcal.template.entity.UsersEntity;
import com.dmortizcal.template.service.UsersService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.ResultMatcher;

import static org.springframework.test.web.client.match.MockRestRequestMatchers.jsonPath;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import java.util.Optional;

@WebMvcTest(UserController.class)
class UserControllerTest {

    @Autowired
    private MockMvc mockMvc;

    @MockBean
    UsersService usersService;

    private UsersEntity usersEntity;

    @BeforeEach
    void setUp() {
        usersEntity = UsersEntity.builder()
                .useId(1L)
                .useEmail("dmortizcal@gmail.com")
                .useName("Mario")
                .build();

    }

    @Test
    void findByName() throws Exception {
        Mockito.when(usersService.findByName("Mario")).thenReturn(Optional.ofNullable(usersEntity));

        mockMvc.perform(get("/findByName/Mario")
                        .contentType(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk());
    }
}