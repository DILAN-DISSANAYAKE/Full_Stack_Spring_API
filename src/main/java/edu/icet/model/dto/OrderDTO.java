package edu.icet.model.dto;

import lombok.*;

import java.time.LocalDate;
import java.util.List;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class OrderDTO {
    private String orderId;
    private String orderDetailsId;
    private String customerId;
    private LocalDate localDate;
    private double totalPrice;
    private List<OrderProductsDTO> orderProductsDTOS;
}
