package edu.icet.controller;

import edu.icet.model.dto.OrderDTO;
import edu.icet.service.OrderService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

@RestController
@RequiredArgsConstructor
@RequestMapping("/order")
public class OrderController {
    private final OrderService orderService;
    @PostMapping("/add")
    public String addOrder(@RequestBody OrderDTO orderDTO){
        return orderService.addOrder(orderDTO);
    }
    @GetMapping("/delete/{id}")
    public String deleteOrder(@PathVariable("id") String id){
        return orderService.deleteOrder(id);
    }

}
