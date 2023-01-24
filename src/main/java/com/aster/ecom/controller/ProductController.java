package com.aster.ecom.controller;

import com.aster.ecom.domain.Product;
import com.aster.ecom.services.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;



    @RestController
    @RequestMapping("/api/products")
    public class ProductController {

        @Autowired
        private ProductService productService;

        @GetMapping("/{id}")
        public ResponseEntity<Product> getProduct(@PathVariable Long id) {
            Product product = productService.getProduct(id);
            return new ResponseEntity<>(product, HttpStatus.OK);
        }

        @PostMapping
        public ResponseEntity<Product> createProduct(@RequestBody Product product) {
            Product newProduct = productService.createProduct(product);
            return new ResponseEntity<>(newProduct, HttpStatus.CREATED);
        }

        @PutMapping("/{id}")
        public ResponseEntity<Product> updateProduct(@PathVariable Long id, @RequestBody Product product) {
            Product updatedProduct = productService.updateProduct(id, product);
            return new ResponseEntity<>(updatedProduct, HttpStatus.OK);
        }

        @DeleteMapping("/{id}")
        public ResponseEntity<Void> deleteProduct(@PathVariable Long id) {
            productService.deleteProduct(id);
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        }
    }
