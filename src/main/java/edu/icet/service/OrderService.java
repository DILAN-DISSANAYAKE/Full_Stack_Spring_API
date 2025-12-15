package edu.icet.service;

import edu.icet.model.dto.OrderDTO;

public interface OrderService {
    String addOrder(OrderDTO orderDTO);

    String deleteOrder(String id);
}
