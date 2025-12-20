package edu.icet.controller;

import edu.icet.model.dto.OrderDTO;
import edu.icet.service.OrderService;
import edu.icet.service.imp.OrderServiceImp;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

@RestController
@RequiredArgsConstructor
@RequestMapping("/order")
public class OrderController {
    private final OrderService orderService;

    @PostMapping("/add")
    public String addOrder(@RequestBody OrderDTO orderDTO) {
        try {
            return orderService.addOrder(orderDTO);
        } catch (Exception e) {
            return e.getMessage();
        }
    }

    @GetMapping("/delete/{id}")
    public String deleteOrder(@PathVariable("id") String id) {
        return orderService.deleteOrder(id);

    }
    @GetMapping("/search/{id}")
    public OrderDTO searchOrder(@PathVariable("id") String id){
        return orderService.searchOrder(id);
    }

}
