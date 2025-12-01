package edu.icet.controller;

import edu.icet.model.dto.ProductDTO;
import edu.icet.service.ProductService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin
@RestController
@RequestMapping("/product")

@RequiredArgsConstructor

public class ProductController {

    private final ProductService productService;

    @PostMapping("/add")
    public String addProduct(@RequestBody ProductDTO productDTO) {
        return productService.addProduct(productDTO);
    }
    @GetMapping("/search/{id}")
    public ProductDTO searchProduct(@PathVariable("id") String id) {
        return productService.searchProduct(id);
    }

    @GetMapping("/all")
    public List<ProductDTO> getAllProducts() {
        return productService.getAllProducts();
    }

    @PostMapping("/update/{id}")
    public String updateProduct(@RequestBody ProductDTO productDTO, @PathVariable("id") String id) {
        return productService.updateProduct(productDTO, id);
    }
    @GetMapping("/delete/{id}")
    public String deleteProduct(@PathVariable("id") String id) {
        return productService.deleteProduct(id);
    }
}
