package edu.icet.repository;

import edu.icet.model.entity.Customer;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface CustomerRepository extends JpaRepository<Customer,String> {
    List<Customer> findByIsActive(boolean isActive);
    Optional<Customer> findByCustomerIdAndIsActiveTrue(String customerId);
}
