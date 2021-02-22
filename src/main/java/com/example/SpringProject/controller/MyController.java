package com.example.SpringProject.controller;


import com.example.SpringProject.dto.Product;
import com.example.SpringProject.dto.ProductRequestDTO;
import com.example.SpringProject.dto.ProductResponseDTO;
import com.example.SpringProject.service.SearchService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.Arrays;



@RestController
public class MyController {

    @Autowired
    SearchService searchService;

    @PostMapping(path = "/search")
    public ProductResponseDTO searchMethod(@RequestBody ProductRequestDTO request){
        return searchService.getProducts(request);
    }



}
