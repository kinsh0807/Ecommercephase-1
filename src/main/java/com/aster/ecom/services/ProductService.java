package com.aster.ecom.services;

import com.aster.ecom.domain.Product;

import java.util.List;

public interface ProductService {
    Product getProduct(Long id);

    Product createProduct(Product product);

    Product updateProduct(Long id, Product product);

    void deleteProduct(Long id);

    List<Product> getAllProducts();


}

