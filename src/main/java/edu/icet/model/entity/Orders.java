package edu.icet.model.entity;

import jakarta.persistence.*;
import lombok.*;

import java.time.LocalDate;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@ToString
@Entity
public class Orders {
    @Id
    @Column(name = "order_id")
    private String orderId;
    @ManyToOne
    @JoinColumn(name = "customer_id")
    private Customer customerId;
    private LocalDate orderDate;
}
