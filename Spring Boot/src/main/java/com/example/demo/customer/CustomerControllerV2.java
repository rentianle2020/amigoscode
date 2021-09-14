package com.example.demo.customer;

import com.example.demo.exception.ApiRequestException;
import lombok.AllArgsConstructor;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RequestMapping(path = "api/v2/customers")
@RestController
@AllArgsConstructor
public class CustomerControllerV2 {

    private final CustomerService customerService;

    @GetMapping
    List<Customer> getCustomers(){
        return customerService.getCustomers();
    }

    @GetMapping(path = "{customerId}")
    Customer getCustomer(@PathVariable(value = "customerId") Long id){
        return customerService.getCustomer(id);
    }

    @GetMapping(path = "{customerId}/exception")
    Customer getCustomerException(@PathVariable(value = "customerId") Long id){
        throw new ApiRequestException("ApiRequestException for customer " + id);
    }

    @PostMapping
    void createNewCustomer(@RequestBody @Valid Customer customer){
        System.out.println("POST REQUEST...");
        System.out.println(customer);
    }

    @PutMapping
    void updateCustomer(@RequestBody Customer customer){
        System.out.println("UPDATE REQUEST...");
        System.out.println(customer);
    }

    @DeleteMapping(path = "{customerId}")
    void deleteCustomer(@PathVariable("customerId") Long id ){
        System.out.println("DELETE REQUEST WITH CUSTOMER ID " + id);
    }


}
