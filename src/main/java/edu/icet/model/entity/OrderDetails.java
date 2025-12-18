package edu.icet.model.entity;

import jakarta.persistence.*;
import lombok.*;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@ToString
@Entity
public class OrderDetails {
    @Id
    @Column(name = "order_details_id")
    private String orderDetailsId;
    @ManyToOne
    @JoinColumn(name = "order_id")
    private Orders ordersId;
    @ManyToOne
    @JoinColumn(name = "product_id")
    private Product productId;
    private double price;
    private int qty;
}
