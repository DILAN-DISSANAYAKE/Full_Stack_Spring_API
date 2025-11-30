package edu.icet.model.dto;

import lombok.*;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class ProductDTO {
    private String productId;
    private String name;
    private double price;
    private int qty;
    private String img;
}
