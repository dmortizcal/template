package com.dmortizcal.template.controller;

import com.dmortizcal.template.entity.UsersEntity;
import com.dmortizcal.template.service.UsersService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@RestController
@RequestMapping("/users")
public class UserController {
    @Autowired
    private UsersService userService;

    @PostMapping("/save")
    public ResponseEntity<UsersEntity> saveUser(@RequestBody UsersEntity user) {
        return new ResponseEntity<>(userService.save(user), HttpStatus.CREATED);
    }

    @GetMapping("/findByName/{name}")
    Optional<UsersEntity> findByName (@PathVariable String name) {
        return userService.findByName(name);
    }
}
