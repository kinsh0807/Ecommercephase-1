package com.aster.ecom.services;


import com.aster.ecom.domain.Cart;
import com.aster.ecom.domain.CartEntry;
import com.aster.ecom.domain.Product;
import com.aster.ecom.domain.Users;
import com.aster.ecom.reposit.CartEntryRepository;
import com.aster.ecom.reposit.CartRepository;
import com.aster.ecom.reposit.ProductRepository;
import jakarta.persistence.EntityNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CartEntryServiceimpl implements CartEntryService {

    @Autowired
    private CartEntryRepository cartEntryRepository;

    @Autowired
    private CartRepository cartRepository;

    @Autowired
    private ProductRepository productRepository;

    @Override
    public CartEntry addProductToCart(Long cartId, Long productId, int quantity) {
        Cart cart = cartRepository.findById(cartId)
                .orElseThrow(() -> new EntityNotFoundException("Cart not found with id " + cartId));
        Product product = productRepository.findById(productId)
                .orElseThrow(() -> new EntityNotFoundException("Product not found with id " + productId));
        CartEntry cartEntry = new CartEntry();
        cartEntry.setCart(cart);
        cartEntry.setQuantity(quantity);
        return cartEntryRepository.save(cartEntry);
    }

    @Override
    public CartEntry updateCartEntry(Long cartEntryId, int newQuantity) {
        CartEntry cartEntry = cartEntryRepository.findById(cartEntryId)
                .orElseThrow(() -> new EntityNotFoundException("Cart entry not found with id " + cartEntryId));
        cartEntry.setQuantity(newQuantity);
        return cartEntryRepository.save(cartEntry);
    }

    @Override
    public void removeProductFromCart(Long cartEntryId) {
        CartEntry cartEntry = cartEntryRepository.findById(cartEntryId)
                .orElseThrow(() -> new EntityNotFoundException("Cart entry not found with id " + cartEntryId));
        cartEntryRepository.delete(cartEntry);
    }

    @Override
    public CartEntry getCartEntry(Long cartEntryId) {
        return cartEntryRepository.findById(cartEntryId)
                .orElseThrow(() -> new EntityNotFoundException("Cart entry not found with id " + cartEntryId));
    }

    @Override
    public List<CartEntry> getCartEntries(Long cartId) {
        Cart cart = cartRepository.findById(cartId)
                .orElseThrow(() -> new EntityNotFoundException("Cart not found with id " + cartId));
        return cartEntryRepository.findByCart(cart);
    }

}


