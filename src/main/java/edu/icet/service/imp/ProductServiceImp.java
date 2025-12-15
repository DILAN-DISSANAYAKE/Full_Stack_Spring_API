package edu.icet.service.imp;

import edu.icet.model.dto.ProductDTO;
import edu.icet.model.entity.Product;
import edu.icet.repository.ProductRepository;
import edu.icet.service.ProductService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
@RequiredArgsConstructor
public class ProductServiceImp implements ProductService {
    final ProductRepository productRepository;
    public String addProduct(ProductDTO productDTO) {
        List<Product> products=productRepository.findAll();
        String genaratedId="P001";
        int genIntId=1;
        for(Product product:products){
            if(product.getProductId().equals(genaratedId)){
                genIntId++;
                genaratedId=String.format("P%03d",genIntId);
            }else{
                break;
            }
        }
        Product product = new Product(
                genaratedId,
                productDTO.getName(),
                productDTO.getPrice(),
                productDTO.getQty(),
                productDTO.getImg()
        );

        productRepository.save(product);
        return "Product Added Successfully..!";
    }

    public ProductDTO searchProduct(String id) {
        Product product=productRepository.findByProductIdAndIsActiveTrue(id).orElse(null);
        if(product!=null){
            return new ProductDTO(id, product.getName(), product.getPrice(), product.getQty(), product.getImg());
        }else{
            ProductDTO productDTO=new ProductDTO();
            productDTO.setName("No Data");
            return productDTO;
        }
    }

    public List<ProductDTO> getAllProducts() {
        List<Product> products=productRepository.findByIsActive(true);
        List<ProductDTO> productsDTOs=new ArrayList<>();
        for(Product product:products){
            productsDTOs.add(new ProductDTO(
                    product.getProductId(),
                    product.getName(),
                    product.getPrice(),
                    product.getQty(),
                    product.getImg()
            ));
        }
        return productsDTOs;
    }

    public String updateProduct(ProductDTO productDTO, String id) {
        Product product=productRepository.findByProductIdAndIsActiveTrue(id).orElse(null);
           if(product != null){
               productRepository.save(new Product(
                  id,
                  productDTO.getName(),
                  productDTO.getPrice(),
                  productDTO.getQty(),
                  productDTO.getImg()
               ));
               return "Product Updated Successfully..!";
           }
        return "Product Doesn't Exist..!";
    }

    public String deleteProduct(String id) {
        Product product=productRepository.findByProductIdAndIsActiveTrue(id).orElse(null);
            if(product != null){
                product.setActive(false);
                productRepository.save(product);
                return "Product Deleted Successfully..!";
            }
        return "Product Doesn't Exist..!";
    }
}
