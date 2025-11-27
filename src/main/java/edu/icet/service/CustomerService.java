package edu.icet.service;

import edu.icet.model.dto.CustomerDTO;
import edu.icet.model.entity.Customer;
import edu.icet.repository.CustomerRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
@RequiredArgsConstructor
public class CustomerService {
    final CustomerRepository customerRepository;
    public String addCustomer(CustomerDTO customerDTO) {
        List<Customer> customers=customerRepository.findAll();
        int genaratedId=1;
        for(Customer customer:customers){
            if(customer.getCustomer_id()==genaratedId){
                genaratedId++;
            }else{break;}
        }
        Customer customer = new Customer(
                genaratedId,
                customerDTO.getName(),
                customerDTO.getAddress(),
                customerDTO.getContact(),
                customerDTO.getImg()
        );

        customerRepository.save(customer);
        return "Customer Added Successfully..!";
    }

    public CustomerDTO searchCustomer(int id) {
        Customer customer=customerRepository.findById(id).orElse(null);
        return customer!=null? new CustomerDTO(id, customer.getName(), customer.getAddress(), customer.getContact(), customer.getImg()):null;
    }

    public List<CustomerDTO> getAllCustomers() {
        List<Customer> customers=customerRepository.findAll();
        List<CustomerDTO> customerDTOS=new ArrayList<>();
        for(Customer customer:customers){
            customerDTOS.add(new CustomerDTO(
                    customer.getCustomer_id(),
                    customer.getName(),
                    customer.getAddress(),
                    customer.getContact(),
                    customer.getImg()
            ));
        }
        return customerDTOS;
    }
}
