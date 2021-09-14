package com.example.demo.customer;

import static org.junit.jupiter.api.Assertions.assertSame;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.mockito.Mockito.any;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import com.example.demo.exception.NotFoundException;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit.jupiter.SpringExtension;

@ContextConfiguration(classes = {CustomerService.class})
@ExtendWith(SpringExtension.class)
public class CustomerServiceTest {
    @MockBean
    private CustomerRepository customerRepository;

    @Autowired
    private CustomerService customerService;

    @Test
    public void testGetCustomers() {
        ArrayList<Customer> customerList = new ArrayList<Customer>();
        when(this.customerRepository.findAll()).thenReturn(customerList);
        List<Customer> actualCustomers = this.customerService.getCustomers();
        assertSame(customerList, actualCustomers);
        assertTrue(actualCustomers.isEmpty());
        verify(this.customerRepository).findAll();
    }

    @Test
    public void testGetCustomer() {
        Customer customer = new Customer();
        when(this.customerRepository.findById((Long) any())).thenReturn(Optional.<Customer>of(customer));
        assertSame(customer, this.customerService.getCustomer(123L));
        verify(this.customerRepository).findById((Long) any());
        assertTrue(this.customerService.getCustomers().isEmpty());
    }

    @Test
    public void testGetCustomer2() {
        when(this.customerRepository.findById((Long) any())).thenReturn(Optional.<Customer>empty());
        assertThrows(NotFoundException.class, () -> this.customerService.getCustomer(123L));
        verify(this.customerRepository).findById((Long) any());
    }
}

