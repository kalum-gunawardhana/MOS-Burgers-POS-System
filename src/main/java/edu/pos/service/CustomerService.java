package edu.pos.service;

import edu.pos.dto.Customer;

import java.util.List;
import java.util.Optional;

public interface CustomerService {
    boolean addCustomer(Customer customer);
    List<Customer> all();
    Customer updateCustomer(Integer id, Customer updatedCustomer);
    void deleteCustomer(Integer id);
    Optional<Customer> getCustomerById(Integer id);
}