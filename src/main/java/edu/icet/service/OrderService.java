package edu.icet.service;

import edu.icet.model.dto.OrderDTO;
import edu.icet.model.entity.Customer;
import edu.icet.model.entity.Orders;
import edu.icet.model.entity.OrderDetails;
import edu.icet.model.entity.Product;
import edu.icet.repository.CustomerRepository;
import edu.icet.repository.OrderDetailsRepository;
import edu.icet.repository.OrderRepository;
import edu.icet.repository.ProductRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.time.LocalDate;
import java.util.List;

@Service
@RequiredArgsConstructor
@Transactional
public class OrderService {
    private final OrderRepository orderRepository;
    private final OrderDetailsRepository orderDetailsRepository;
    private final ProductRepository productRepository;
    private final CustomerRepository customerRepository;

    public String addOrder(OrderDTO orderDTO) {
        try {
            Customer customer = customerRepository.findById(orderDTO.getCustomerId()).orElse(null);
            Product product = productRepository.findById(orderDTO.getProductId()).orElse(null);
            if (customer == null || product == null) {
                return "Customer or Product doesn't Exist..!";
            }
            if ((product.getQty() - orderDTO.getQty()) < 0) {
                return "Not Enough Quantity..!";
            }
            String genOrderId=genOrderId();
            orderRepository.save(new Orders(
                    genOrderId,
                    customer,
                    LocalDate.now()
            ));

            orderDetailsRepository.save(new OrderDetails(
                    genOrderDetailId(),
                    orderRepository.findById(genOrderId).orElse(null),
                    product,
                    orderDTO.getQty()

            ));
            product.setQty(product.getQty() - orderDTO.getQty());
            productRepository.save(product);
            return "Order Added Successfully..!";
        } catch (
                Exception e) {
            return e.getMessage();
        }
    }

    public String genOrderId() {
        List<Orders> ordersList = orderRepository.findAll();
        String genaratedId = "O001";
        int genIntId = 1;
        for (Orders orders : ordersList) {
            if (orders.getOrderId().equals(genaratedId)) {
                genIntId++;
                genaratedId = String.format("O%03d", genIntId);
            } else {
                break;
            }
        }
        return genaratedId;
    }

    public String genOrderDetailId() {
        List<OrderDetails> oderDetailsList = orderDetailsRepository.findAll();
        String genaratedId2 = "D001";
        int genIntId2 = 1;
        for (OrderDetails orderDetails : oderDetailsList) {
            if (orderDetails.getOrderDetailsId().equals(genaratedId2)) {
                genIntId2++;
                genaratedId2 = String.format("D%03d", genIntId2);
            } else {
                break;
            }
        }
        return genaratedId2;
    }
}
