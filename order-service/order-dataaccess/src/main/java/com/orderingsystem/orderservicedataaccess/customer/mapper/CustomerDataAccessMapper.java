package com.orderingsystem.orderservicedataaccess.customer.mapper;

import com.orderingsystem.orderservicedataaccess.customer.entity.CustomerEntity;
import com.orderingsystem.orderservicedomain.entity.Customer;
import com.orderingsystem.valueobject.CustomerId;
import org.springframework.stereotype.Component;

@Component
public class CustomerDataAccessMapper {

    public Customer customerEntityToCustomer(CustomerEntity customerEntity) {
        return new Customer(new CustomerId(customerEntity.getId()));
    }

    public CustomerEntity customerToCustomerEntity(Customer customer) {
        return CustomerEntity.builder()
                .id(customer.getId().getValue())
                .username(customer.getUsername())
                .firstName(customer.getFirstName())
                .lastName(customer.getLastName())
                .build();
    }
}
