package edu.icet.controller;

import edu.icet.model.dto.CustomerDTO;
import edu.icet.service.CustomerService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin
@RestController
@RequestMapping("/customer")

@RequiredArgsConstructor

public class CustomerController {

    private final CustomerService customerService;

    @PostMapping("/add")
    public String addCustomer(@RequestBody CustomerDTO customerDTO){
        return customerService.addCustomer(customerDTO);
    }
    @GetMapping("/search/{id}")
    public CustomerDTO searchCustomer(@PathVariable("id") String id){
        return customerService.searchCustomer(id);
    }
    @GetMapping("/all")
    public List<CustomerDTO> getAllCustomers() {
        return customerService.getAllCustomers();
    }
    @PostMapping("/update/{id}")
    public String updateCustomer(@RequestBody CustomerDTO customerDTO, @PathVariable("id") String id){
        return customerService.updateCustomer(customerDTO,id);
    }
    @GetMapping("/delete/{id}")
    public String deleteCustomer(@PathVariable("id") String id){
        return customerService.deleteCustomer(id);
    }
}
