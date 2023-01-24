package com.aster.ecom.services;

import com.aster.ecom.domain.Cart;
import com.aster.ecom.domain.CartEntry;
import com.aster.ecom.domain.Product;
import com.aster.ecom.domain.Users;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

public interface CartEntryService {
    CartEntry addProductToCart(Long cartId, Long productId, int quantity);

    CartEntry updateCartEntry(Long cartEntryId, int newQuantity);

    void removeProductFromCart(Long cartEntryId);

    CartEntry getCartEntry(Long cartEntryId);

    List<CartEntry> getCartEntries(Long cartId);
}
