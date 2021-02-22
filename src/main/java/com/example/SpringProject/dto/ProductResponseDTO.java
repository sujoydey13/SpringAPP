package com.example.SpringProject.dto;

import java.util.List;

public class ProductResponseDTO {
    private List<Product> productList;

    public List<Product> getProductList() {
        return productList;
    }

    public void setProductList(List<Product> productList) {
        this.productList = productList;
    }
}
