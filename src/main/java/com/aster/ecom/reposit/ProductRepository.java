package com.aster.ecom.reposit;

import com.aster.ecom.domain.Product;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ProductRepository extends JpaRepository<Product, Long> {

    Product findBySku(String sku);
    void deleteBySku(String sku);
}
