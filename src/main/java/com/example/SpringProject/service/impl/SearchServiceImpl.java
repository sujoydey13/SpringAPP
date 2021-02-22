package com.example.SpringProject.service.impl;

import com.example.SpringProject.dto.Product;
import com.example.SpringProject.dto.ProductRequestDTO;
import com.example.SpringProject.dto.ProductResponseDTO;
import com.example.SpringProject.service.SearchService;
import org.springframework.stereotype.Service;

import java.util.Arrays;

@Service
public class SearchServiceImpl implements SearchService {

    public ProductResponseDTO getProducts(ProductRequestDTO requestDTO) {
        ProductResponseDTO responseDTO = new ProductResponseDTO();
        Product product1 = new Product();
        product1.setTitle("Smartphone");
        product1.setInstock(true);
        product1.setSalePrice(15999);
        product1.setDescription("Xiami Redmi Note 5 pro");
        responseDTO.setProductList(Arrays.asList(product1));
        return responseDTO;
    }
}
