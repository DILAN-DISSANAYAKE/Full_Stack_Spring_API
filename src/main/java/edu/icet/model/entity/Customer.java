package edu.icet.model.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import lombok.*;

@Getter
@Setter
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
    private boolean isActive=true;

    public Customer(String customerId, String name, String address, String contact, String img) {
        this.customerId = customerId;
        this.name = name;
        this.address = address;
        this.contact = contact;
        this.img = img;
    }
}
