package edu.icet.model.dto;

import lombok.*;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class ProductDTO {
    private String product_id;
    private String name;
    private String price;
    private String qty;
    private String img;
}
