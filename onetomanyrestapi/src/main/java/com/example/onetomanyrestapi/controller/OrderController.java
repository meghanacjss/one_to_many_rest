package com.example.onetomanyrestapi.controller;

import com.example.onetomanyrestapi.dto.OrderRequest;
import com.example.onetomanyrestapi.dto.OrderResponse;
import com.example.onetomanyrestapi.entity.Customer;
import com.example.onetomanyrestapi.repository.CustomerRepository;
import com.example.onetomanyrestapi.repository.ProductRepository;
import org.hibernate.query.Order;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class OrderController {

    @Autowired
    private CustomerRepository customerRepository;
    @Autowired
    private ProductRepository productRepository;
@PostMapping("/placeOrder")
    public Customer placeOrder(@RequestBody OrderRequest request){
        return customerRepository.save(request.getCustomer());
    }
@GetMapping("/findAllOrders")
    public List<Customer> findAllOrders(){

    return customerRepository.findAll();
    }

    @GetMapping("/getInfo")
    public List<OrderResponse>getJoinInformation(){
    return customerRepository.getJoinInformation();

    }

    @PutMapping("/updateOrder/{id}")
    public Customer updateOrder(@PathVariable int id, @RequestBody OrderRequest request) {
        Customer existingCustomer = customerRepository.findById(id).orElse(null);

        if (existingCustomer != null) {
            existingCustomer.setName(request.getCustomer().getName());
            existingCustomer.setEmail(request.getCustomer().getEmail());
            existingCustomer.setGender(request.getCustomer().getGender());

            return customerRepository.save(existingCustomer);
        }
        return null;
    }

    @DeleteMapping("/deleteOrder/{id}")
    public String deleteOrder(@PathVariable int id) {
        customerRepository.deleteById(id);
        return "Order deleted successfully";
    }
}
