package com.example.SpringProject.dto;

import java.util.List;

public class ProductResponseDTO {
    private List<Object> productList;

    public List<Object> getProductList() {
        return productList;
    }

    public void setProductList(List<Object> productList) {
        this.productList = productList;
    }
}
