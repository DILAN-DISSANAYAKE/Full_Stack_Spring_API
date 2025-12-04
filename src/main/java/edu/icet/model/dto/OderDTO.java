package edu.icet.model.dto;

import lombok.*;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class OderDTO {
    private String oderId;
    private String oderDetailsId;
    private String customerId;
    private String productId;
    private String qty;
}
