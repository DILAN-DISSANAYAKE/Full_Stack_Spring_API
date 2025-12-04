package edu.icet.model.entity;

import jakarta.persistence.*;
import lombok.*;

import java.time.LocalDate;
import java.util.List;

@Getter
@Setter
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
    @OneToMany(mappedBy = "ordersId",cascade = CascadeType.ALL,orphanRemoval = true)
    private List<OrderDetails> orderDetailsList;

    public Orders(String orderId, Customer customerId, LocalDate orderDate) {
        this.orderId = orderId;
        this.customerId = customerId;
        this.orderDate = orderDate;
    }
}
