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
        String genaratedId="C001";
        int genIntId=1;
        for(Customer customer:customers){
            if(customer.getCustomer_id().equals(genaratedId)){
                genIntId++;
                genaratedId=String.format("C%03d",genIntId);
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

    public CustomerDTO searchCustomer(String id) {
        Customer customer=customerRepository.findById(id).orElse(null);
        if(customer!=null){
            return new CustomerDTO(id, customer.getName(), customer.getAddress(), customer.getContact(), customer.getImg());
        }else{
            CustomerDTO customerDTO=new CustomerDTO();
            customerDTO.setName("No Data");
            return customerDTO;
        }
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

    public String updateCustomer(CustomerDTO customerDTO, String id) {
        List<Customer> customers=customerRepository.findAll();
        for(Customer customer:customers){
           if(customer.getCustomer_id().equals(id)){
               customerRepository.save(new Customer(
                  id,
                  customerDTO.getName(),
                  customerDTO.getAddress(),
                  customerDTO.getContact(),
                  customerDTO.getImg()
               ));
               return "Customer Updated Successfully..!";
           }
        }
        return "Customer Doesn't Exist..!";
    }

    public String deleteCustomer(String id) {
        List<Customer> customers=customerRepository.findAll();
        for(Customer customer:customers){
            if(customer.getCustomer_id().equals(id)){
                customerRepository.deleteById(id);
                return "Customer Deleted Successfully..!";
            }
        }
        return "Customer Doesn't Exist..!";
    }
}
