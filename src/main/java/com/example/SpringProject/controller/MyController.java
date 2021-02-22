package com.example.SpringProject.controller;

import com.example.SpringProject.DTO.MyRequestDTO;
import com.example.SpringProject.DTO.MyResponseDTO;
import org.springframework.web.bind.annotation.*;

@RestController
public class MyController {

    @GetMapping(path = "/hello")
    public String helloWorld(){
        return "success!!!";
    }

    @PostMapping(path = "/hello-post")
    public String helloWorldPost(){
        return "success Post";
    }

    @GetMapping(path = "/hello-query")
    public String helloQuery(@RequestParam String query){
        return "query = "+query;
    }

    @PostMapping(value = "/regist")
    public String registerUser(@RequestBody MyRequestDTO request){
        return request.toString();
    }

    @GetMapping(path = "/employee/{employeeId}")
    public MyResponseDTO getEmployeeDetails(@PathVariable String employeeId){
        MyResponseDTO response = new MyResponseDTO();
        response.setId(employeeId);
        return response;
    }
}
