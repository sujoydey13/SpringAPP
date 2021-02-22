package com.example.SpringProject.services.impl;


import com.example.SpringProject.DTO.MyRequestDTO;
import com.example.SpringProject.services.UserService;
import org.springframework.stereotype.Service;

import javax.annotation.PostConstruct;

@Service
public class UserServiceImpl implements UserService {

    public UserServiceImpl() {
        System.out.println("Inside UserService Constructor....");
    }

    @PostConstruct
    public void init(){
        System.out.println("Inside UserService PostConstructor...");
    }

    @Override
    public boolean updateEmployee(MyRequestDTO request, String id) {
        System.out.println("inside user services "+request+" id: "+id);
        return false;
    }
}
