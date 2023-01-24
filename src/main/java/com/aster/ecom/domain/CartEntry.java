package com.aster.ecom.domain;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;

@NoArgsConstructor
@AllArgsConstructor
@Data


@Entity
@Table(name = "cart_entry")
public class CartEntry {
        @Id
        @GeneratedValue(strategy = GenerationType.IDENTITY)
        private Long id;

        @OneToOne
        @JoinColumn(name = "product_id")
        private Product product;

        private Integer quantity;
        private BigDecimal price;
        @ManyToOne
        @JoinColumn(name="cart_id")
    private Cart cart;

}






