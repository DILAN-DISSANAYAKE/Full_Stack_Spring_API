package edu.icet.service;

import edu.icet.model.dto.CustomerDTO;

import java.util.List;

public interface CustomerService {

    String addCustomer(CustomerDTO customerDTO);

    CustomerDTO searchCustomer(String id);

    List<CustomerDTO> getAllCustomers();

    String updateCustomer(CustomerDTO customerDTO, String id);

    String deleteCustomer(String id);
}
