package com.springboot.advanced_jpa.service;


import com.springboot.advanced_jpa.data.dto.ProductDto;

public interface ProductService {

    com.springboot.advanced_jpa.data.dto.ProductResponseDto getProduct(Long number);

    com.springboot.advanced_jpa.data.dto.ProductResponseDto saveProduct(ProductDto productDto);

    com.springboot.advanced_jpa.data.dto.ProductResponseDto changeProductName(Long number, String name) throws Exception;

    void deleteProduct(Long number) throws Exception;

}
