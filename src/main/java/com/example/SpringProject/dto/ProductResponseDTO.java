package com.example.SpringProject.dto;

import java.util.List;

public class ProductResponseDTO {
    private List<Product> productList;

    private List<Product> loactionBasedProductList;

    public List<Product> getProductList() {
        return productList;
    }

    public void setProductList(List<Product> productList) {
        this.productList = productList;
    }

    public List<Product> getLoactionBasedProductList() {
        return loactionBasedProductList;
    }

    public void setLoactionBasedProductList(List<Product> loactionBasedProductList) {
        this.loactionBasedProductList = loactionBasedProductList;
    }
}
