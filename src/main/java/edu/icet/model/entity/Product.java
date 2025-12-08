package edu.icet.model.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import lombok.*;

@Getter
@Setter
@NoArgsConstructor
@ToString
@Entity
public class Product {
    @Id
    @Column(name = "product_id")
    private String productId;
    private String name;
    private double price;
    private int qty;
    private String img;
    private boolean isActive=true;

    public Product(String productId, String name, double price, int qty, String img) {
        this.productId = productId;
        this.name = name;
        this.price = price;
        this.qty = qty;
        this.img = img;
    }
}
