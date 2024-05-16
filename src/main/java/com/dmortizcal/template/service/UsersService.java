package com.dmortizcal.template.service;

import com.dmortizcal.template.entity.UsersEntity;
import com.dmortizcal.template.repository.UsersRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class UsersService {
    @Autowired
    private UsersRepository userRepository;

    public UsersEntity save(UsersEntity user) {
        return userRepository.save(user);
    }


    public Optional<UsersEntity> findByName(String name){
        return userRepository.findByUseName(name);
    }

}
