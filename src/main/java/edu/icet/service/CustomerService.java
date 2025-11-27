package edu.icet.service;

import edu.icet.model.dto.CustomerDTO;
import edu.icet.model.entity.Customer;
import edu.icet.repository.CustomerRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class CustomerService {
    final CustomerRepository customerRepository;
    public String addCustomer(CustomerDTO customerDTO) {
        Customer customer = new Customer(
                customerDTO.getCustomer_id(),
                customerDTO.getName(),
                customerDTO.getAddress(),
                customerDTO.getContact(),
                customerDTO.getImg()
        );

        customerRepository.save(customer);
        return "Customer Added Successfully..!";
    }
}
