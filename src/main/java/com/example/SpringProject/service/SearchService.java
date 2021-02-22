package com.example.SpringProject.service;

import com.example.SpringProject.dto.ProductRequestDTO;
import com.example.SpringProject.dto.ProductResponseDTO;

public interface SearchService {
    ProductResponseDTO getProducts(ProductRequestDTO requestDTO);
}
