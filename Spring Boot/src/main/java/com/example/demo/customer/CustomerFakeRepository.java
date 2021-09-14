package com.example.demo.customer;

import java.util.Arrays;
import java.util.List;

@Deprecated
public class CustomerFakeRepository implements CustomerRepo {
    @Override
    public List<Customer> getCustomers() {
        return Arrays.asList(
                new Customer(1L, "Tyler Ren", "password123", "tyler@gmail.com"),
                new Customer(2L, "Cen Bao", "123password", "cencen@gmail.com")
        );
    }
}
