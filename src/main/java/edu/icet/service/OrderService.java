package edu.icet.service;

import edu.icet.model.dto.OrderDTO;

import java.util.List;

public interface OrderService {
    String addOrder(OrderDTO orderDTO);

    String deleteOrder(String id);

    OrderDTO searchOrder(String id);

    List<OrderDTO> getAllOrders();
}
