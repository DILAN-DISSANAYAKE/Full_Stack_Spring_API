package edu.icet.model.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import lombok.*;

@Getter
@Setter
@AllArgsConstructor
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
}
