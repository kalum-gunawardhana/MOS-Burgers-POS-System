package edu.pos.service.impl;

import edu.pos.dto.Customer;
import edu.pos.entity.CustomerEntity;
import edu.pos.repository.CustomerDao;
import edu.pos.service.CustomerService;
import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class CustomerServiceImpl implements CustomerService {
    final CustomerDao customerDao;
    final ModelMapper modelMapper;

    @Override
    public boolean addCustomer(Customer customer) {
        try {
            customerDao.save(modelMapper.map(customer, CustomerEntity.class));
            return true;
        }catch (Exception ex){
            return false;
        }
    }

    @Override
    public List<Customer> all() {
        List<CustomerEntity> customers = customerDao.findAll();
        return customers.stream().map(customerEntity -> modelMapper.map(customerEntity, Customer.class)).collect(Collectors.toUnmodifiableList());
    }

    @Override
    public Customer updateCustomer(Integer id, Customer updatedCustomer) {
        return customerDao.findById(id)
                .map(existingCustomer -> {
                    existingCustomer.setName(updatedCustomer.getName());
                    existingCustomer.setEmail(updatedCustomer.getEmail());
                    existingCustomer.setPhone(updatedCustomer.getPhone());
                    CustomerEntity customerEntity = customerDao.save(existingCustomer);
                    return modelMapper.map(customerEntity, Customer.class);
                })
                .orElseThrow(() -> new RuntimeException("Customer not found with ID: " + id));
    }

    @Override
    public void deleteCustomer(Integer id) {
        customerDao.deleteById(id);
    }

    @Override
    public Optional<Customer> getCustomerById(Integer id) {
        Optional<CustomerEntity> byId = customerDao.findById(id);
        return Optional.ofNullable(modelMapper.map(byId, Customer.class));
    }
}
