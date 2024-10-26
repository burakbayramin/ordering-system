package com.orderingsystem.orderservicedomain.ports.output.repository;

import com.orderingsystem.orderservicedomain.entity.Customer;

import java.util.Optional;
import java.util.UUID;

public interface CustomerRepository {

    Optional<Customer> findCustomer(UUID customerId);
}
