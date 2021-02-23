package com.example.SpringProject.service.impl;

import com.example.SpringProject.client.SearchClient;
import com.example.SpringProject.dto.Product;
import com.example.SpringProject.dto.ProductRequestDTO;
import com.example.SpringProject.dto.ProductResponseDTO;
import com.example.SpringProject.service.SearchService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.*;

@Service
public class SearchServiceImpl implements SearchService {

    @Autowired
    private SearchClient searchClient;

    @Override
    public ProductResponseDTO getProducts(ProductRequestDTO requestDTO) {

        String str = "stockLocation:"+"\""+requestDTO.getStockLocation()+"\"";

        Map<String,Object> productResponse = searchClient.getProducts(requestDTO.getSearchTerm());

        List<Product> productList = new ArrayList<Product>();

        List<Map<String, Object>> products = (List<Map<String, Object>>) (((Map<String, Object>) (productResponse.get("response"))).get("docs"));
        for (Map<String, Object> product: products) {
            Product p1 = new Product();
            p1.setDescription((String) product.get("description"));
            int n = (int)product.get("isInStock");
            boolean t = n==1?true:false;
            p1.setInstock(t);
            p1.setSalePrice((double)product.get("salePrice"));
            p1.setTitle((String)product.get("name"));
            productList.add(p1);
        }
        ProductResponseDTO responseDTO = new ProductResponseDTO();
        responseDTO.setProductList(productList);

        Map<String,Object> productResponse1 = searchClient.getProducts(str);
        List<Product> locationBasedProductList = new ArrayList<Product>();
        List<Map<String, Object>> locationBasedProducts = (List<Map<String, Object>>) (((Map<String, Object>) (productResponse1.get("response"))).get("docs"));
        for (Map<String, Object> product: locationBasedProducts) {
            Product p1 = new Product();
            p1.setDescription((String) product.get("description"));
            int n = (int)product.get("isInStock");
            boolean t = n==1?true:false;
            p1.setInstock(t);
            p1.setSalePrice((double)product.get("salePrice"));
            p1.setTitle((String)product.get("name"));
            locationBasedProductList.add(p1);
        }
        responseDTO.setLoactionBasedProductList(locationBasedProductList);

        return responseDTO;

    }
}
