package edu.icet.service.imp;

import edu.icet.model.dto.OrderDTO;
import edu.icet.model.dto.OrderProductsDTO;
import edu.icet.model.entity.Customer;
import edu.icet.model.entity.Orders;
import edu.icet.model.entity.OrderDetails;
import edu.icet.model.entity.Product;
import edu.icet.repository.CustomerRepository;
import edu.icet.repository.OrderDetailsRepository;
import edu.icet.repository.OrderRepository;
import edu.icet.repository.ProductRepository;
import edu.icet.service.OrderService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.time.LocalDate;
import java.util.List;

@Service
@RequiredArgsConstructor
@Transactional
public class OrderServiceImp implements OrderService {
    private final OrderRepository orderRepository;
    private final OrderDetailsRepository orderDetailsRepository;
    private final ProductRepository productRepository;
    private final CustomerRepository customerRepository;

    @Override
    public String addOrder(OrderDTO orderDTO) {
            List<OrderProductsDTO> orderProductsDTOList = orderDTO.getOrderProductsDTOS();
            if (orderProductsDTOList == null) {
                return "Empty Order Try again..!";
            }
            Customer customer = customerRepository.findByCustomerIdAndIsActiveTrue(orderDTO.getCustomerId()).orElse(null);
            if (customer == null) {
                return "Customer doesn't Exist..!";
            }
            String genOrderId=genOrderId();
            orderRepository.save(new Orders(
                    genOrderId,
                    customer,
                    LocalDate.now()
            ));
            for (OrderProductsDTO orderProductsDTOTemp:orderProductsDTOList){
                Product product = productRepository.findByProductIdAndIsActiveTrue(orderProductsDTOTemp.getProductId()).orElse(null);
                if(product==null){
                    throw new IllegalArgumentException("Product "+orderProductsDTOTemp.getProductId()+" doesn't Exist Try again..!");
                }
                if((product.getQty() - orderProductsDTOTemp.getQty()) < 0){
                    throw new IllegalArgumentException("Not Enough Quantity in product "+orderProductsDTOTemp.getProductId()+" ..!");
                }
                orderDetailsRepository.save(new OrderDetails(
                        genOrderDetailId(),
                        orderRepository.findById(genOrderId).orElse(null),
                        product,
                        product.getPrice(),
                        orderProductsDTOTemp.getQty()
                ));
                product.setQty(product.getQty() - orderProductsDTOTemp.getQty());
                productRepository.save(product);
            }

            return "Order Added Successfully..!";
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

    @Override
    public String deleteOrder(String id){
        Orders orders=orderRepository.findById(id).orElse(null);
        if (orders != null) {
            List<OrderDetails> orderDetails = orderDetailsRepository.findAllByOrdersId_OrderId(id);
            for (OrderDetails orderDetail:orderDetails){
                Product product = productRepository.findByProductIdAndIsActiveTrue(orderDetail.getProductId().getProductId()).orElse(null);
                if (product == null) {
                    throw new IllegalArgumentException("Something went Wrong Try again..!");
                }
                product.setQty(product.getQty()+orderDetail.getQty());
                productRepository.save(product);
            }
            orderRepository.deleteById(id);
            return "Order Deleted Successfully..!";
        }
        return "Order Doesn't Exist..!";
    }

    @Override
    public OrderDTO searchOrder(String id) {
        return null;
    }
}
