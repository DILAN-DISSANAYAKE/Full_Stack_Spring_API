package edu.icet.service;

import edu.icet.model.dto.ProductDTO;

import java.util.List;

public interface ProductService {
    String addProduct(ProductDTO productDTO);

    ProductDTO searchProduct(String id);

    List<ProductDTO> getAllProducts();

    String updateProduct(ProductDTO productDTO, String id);

    String deleteProduct(String id);
}
