package edu.icet.model.dto;

import lombok.*;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class OrderProductsDTO {
    private String productId;
    private int qty;
    private double price;
}
