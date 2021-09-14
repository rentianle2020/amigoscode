package com.example.demo.customer;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;

public class CustomerTest {
    @Test
    public void testConstructor() {
        Customer actualCustomer = new Customer(123L, "Name", "iloveyou", "jane.doe@example.org");

        assertEquals("jane.doe@example.org", actualCustomer.getEmail());
        assertEquals("Customer{id=123, name='Name', password='iloveyou', email='jane.doe@example.org'}",
                actualCustomer.toString());
        assertEquals("iloveyou", actualCustomer.getPassword());
        assertEquals("Name", actualCustomer.getName());
        assertEquals(123L, actualCustomer.getId().longValue());
    }

    @Test
    public void testConstructor2() {
        Customer actualCustomer = new Customer(123L, "Name", "iloveyou", "jane.doe@example.org");

        assertEquals("jane.doe@example.org", actualCustomer.getEmail());
        assertEquals("Customer{id=123, name='Name', password='iloveyou', email='jane.doe@example.org'}",
                actualCustomer.toString());
        assertEquals("iloveyou", actualCustomer.getPassword());
        assertEquals("Name", actualCustomer.getName());
        assertEquals(123L, actualCustomer.getId().longValue());
    }
}

