package com.aster.ecom.reposit;


import com.aster.ecom.domain.Cart;
import com.aster.ecom.domain.CartEntry;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface CartEntryRepository extends JpaRepository<CartEntry, Long> {


    CartEntry findByProductSkuAndCartId(String sku, Long cartId);
    void deleteByProductSkuAndCartId(String sku, Long cartId);
    List<CartEntry> findByCart(Cart cart);

    @Modifying
    @Query("update CartEntry set quantity = :quantity where product_sku = :sku and cart_id = :cartId")
    void updateQuantity(@Param("sku") String sku, @Param("cartId") Long cartId, @Param("quantity") Integer quantity);
}
