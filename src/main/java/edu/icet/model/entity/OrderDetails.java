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
public class OrderDetails {
    @Id
    @Column(name = "oder_details_id")
    private String orderDetailsId;
    private String orderId;
    private String productId;
    private String qty;
}
