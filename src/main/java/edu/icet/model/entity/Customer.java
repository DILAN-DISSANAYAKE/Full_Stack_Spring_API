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
public class Customer {
    @Id
    @Column(name = "customer_id")
    private String customerId;
    private String name;
    private String address;
    private String contact;
    private String img;
}
