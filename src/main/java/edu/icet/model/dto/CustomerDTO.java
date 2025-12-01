package edu.icet.model.dto;

import lombok.*;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class CustomerDTO {
    private String customerId;
    private String name;
    private String address;
    private String contact;
    private String img;
}
