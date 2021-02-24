package com.example.SpringProject.service.impl;

import com.example.SpringProject.client.SearchClient;
import com.example.SpringProject.dto.ProductRequestDTO;
import com.example.SpringProject.dto.ProductResponseDTO;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;
import org.mockito.junit.MockitoJUnitRunner;

import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.Map;

import static org.junit.jupiter.api.Assertions.*;

@RunWith(MockitoJUnitRunner.class)
class SearchServiceImplTest {

    @InjectMocks
    private SearchServiceImpl searchService;

    @Mock
    private SearchClient searchClient;

    @BeforeEach
    public void init(){
        MockitoAnnotations.openMocks(this);
    }

    @Test
    void getProducts() throws IOException {
        ObjectMapper objectMapper = new ObjectMapper();
        Map<String,Object> searchTermMockObject = objectMapper.readValue(new URL("file:src/main/resources/search.mock"), Map.class);
        Map<String, Object> locationMockObject = objectMapper.readValue(new URL("file:src/main/resources/location.mock"), Map.class);

        Mockito.when(searchClient.getProducts("samsung")).thenReturn(searchTermMockObject);
        Mockito.when(searchClient.getProducts("stockLocation:\"jakarta\"")).thenReturn(locationMockObject);


        ProductRequestDTO requestDTO = new ProductRequestDTO();
        requestDTO.setSearchTerm("samsung");
        requestDTO.setStockLocation("jakarta");
        ProductResponseDTO responseDTO = searchService.getProducts(requestDTO);

        assertEquals(responseDTO.getProductList().size(), 10);
        assertEquals(responseDTO.getProductList().size(), 10);

        Mockito.verify(searchClient).getProducts("samsung");
        Mockito.verify(searchClient).getProducts("stockLocation:\"jakarta\"");
    }

    @Test
    public void testGetProductsException() throws IOException {
        ObjectMapper objectMapper = new ObjectMapper();
        Map<String,Object> searchTermMockObject = objectMapper.readValue(new URL("file:src/main/resources/search.mock"), Map.class);
        Map<String, Object> locationMockObject = objectMapper.readValue(new URL("file:src/main/resources/location.mock"), Map.class);

        Mockito.when(searchClient.getProducts("samsung")).thenReturn(searchTermMockObject);
        Mockito.when(searchClient.getProducts("stockLocation:\"jakarta\"")).thenThrow(NullPointerException.class);


        ProductRequestDTO requestDTO = new ProductRequestDTO();
        requestDTO.setSearchTerm("samsung");
        requestDTO.setStockLocation("jakarta");
        ProductResponseDTO responseDTO = searchService.getProducts(requestDTO);

        assertEquals(responseDTO.getProductList().size(), 10);
        assertEquals(responseDTO.getLoactionBasedProductList(), null);

        Mockito.verify(searchClient).getProducts("samsung");
        Mockito.verify(searchClient).getProducts("stockLocation:\"jakarta\"");
    }
}