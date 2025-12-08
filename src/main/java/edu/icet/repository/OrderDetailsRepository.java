package edu.icet.repository;

import edu.icet.model.entity.OrderDetails;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface OrderDetailsRepository extends JpaRepository<OrderDetails,String> {
    List<OrderDetails> findAllByOrdersId_OrderId(String orderId);

}
