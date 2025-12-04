package edu.icet.model.dto;

import lombok.*;

import java.time.LocalDate;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class OrderDTO {
    private String orderId;
    private String orderDetailsId;
    private String customerId;
    private String productId;
    private int qty;
    private LocalDate localDate;
    private double totalPrice;
}
