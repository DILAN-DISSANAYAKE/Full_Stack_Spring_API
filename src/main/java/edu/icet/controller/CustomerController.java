package edu.icet.controller;

import edu.icet.model.dto.CustomerDTO;
import edu.icet.service.CustomerService;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/customer")

@RequiredArgsConstructor

public class CustomerController {

    final CustomerService customerService;

//    CustomerController(CustomerService customerService){
//        this.customerService=customerService;
//
//    }

    @PostMapping("/add")
    public String addCustomer(@RequestBody CustomerDTO customerDTO){
        return customerService.addCustomer(customerDTO);
    }
}
