package edu.pos.controller;

import edu.pos.dto.Customer;
import edu.pos.entity.CustomerEntity;
import edu.pos.repository.CustomerDao;
import edu.pos.service.CustomerService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/customer")
@RequiredArgsConstructor
@CrossOrigin
public class CustomerController {
    final CustomerService customerService;

    @PostMapping("/add")
    public ResponseEntity<String> addCustomer(@RequestBody Customer customer){
        boolean added = customerService.addCustomer(customer);

        if (added){
            return ResponseEntity.ok("successfully!");
        }else {
            return ResponseEntity.ok("fail!");
        }
    }

    @GetMapping("/all")
    public ResponseEntity<List<Customer>> allCustomers(){
        List<Customer> customerList = customerService.all();
        return ResponseEntity.ok(customerList);
    }

    @PutMapping("/update/{id}")
    public ResponseEntity<Customer> updateCustomer(@PathVariable Integer id, @RequestBody Customer updatedCustomer) {
        try {
            Customer updated = customerService.updateCustomer(id, updatedCustomer);
            return ResponseEntity.ok(updated);
        } catch (RuntimeException e) {
            return ResponseEntity.notFound().build();
        }
    }

    // Delete a customer
    @DeleteMapping("/delete/{id}")
    public ResponseEntity<Void> deleteCustomer(@PathVariable Integer id) {
        customerService.deleteCustomer(id);
        return ResponseEntity.noContent().build();
    }

    // Get a single customer by ID
    @GetMapping("/{id}")
    public ResponseEntity<Customer> getCustomerById(@PathVariable Integer id) {
        Optional<Customer> customer = customerService.getCustomerById(id);
        return customer.map(ResponseEntity::ok)
                .orElseGet(() -> ResponseEntity.notFound().build());
    }
    
}
