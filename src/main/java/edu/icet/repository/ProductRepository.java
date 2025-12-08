package edu.icet.repository;

import edu.icet.model.entity.Customer;
import edu.icet.model.entity.Product;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface ProductRepository extends JpaRepository<Product,String> {
    List<Product> findByIsActive(boolean isActive);
    Optional<Product> findByProductIdAndIsActiveTrue(String productId);
}
