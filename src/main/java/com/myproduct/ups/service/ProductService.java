package com.myproduct.ups.service;

import com.myproduct.ups.model.Product;
import com.myproduct.ups.model.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProductService {
    @Autowired
    private ProductRepository productRepository;
    
    public Product createProduct(Product product)
    {
        Product productfromdb = productRepository.save(product);
        return productfromdb;
    }

    public List<Product> Allproducts()
    {
        return productRepository.findAll();
    }
}
