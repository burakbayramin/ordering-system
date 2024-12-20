package com.orderingsystem.orderservicedataaccess.customer.adapter;

import com.orderingsystem.orderservicedataaccess.customer.mapper.CustomerDataAccessMapper;
import com.orderingsystem.orderservicedataaccess.customer.repository.CustomerJpaRepository;
import com.orderingsystem.orderservicedomain.entity.Customer;
import com.orderingsystem.orderservicedomain.ports.output.repository.CustomerRepository;
import org.springframework.stereotype.Component;

import java.util.Optional;
import java.util.UUID;

@Component
public class CustomerRepositoryImpl implements CustomerRepository {

    private final CustomerJpaRepository customerJpaRepository;
    private final CustomerDataAccessMapper customerDataAccessMapper;

    public CustomerRepositoryImpl(CustomerJpaRepository customerJpaRepository,
                                  CustomerDataAccessMapper customerDataAccessMapper) {
        this.customerJpaRepository = customerJpaRepository;
        this.customerDataAccessMapper = customerDataAccessMapper;
    }

    @Override
    public Optional<Customer> findCustomer(UUID customerId) {
        return customerJpaRepository.findById(customerId).map(customerDataAccessMapper::customerEntityToCustomer);
    }

//    @Override
//    @Transactional
//    public Customer save(Customer customer) {
//        return customerDataAccessMapper.customerEntityToCustomer(
//                customerJpaRepository.save(customerDataAccessMapper.customerToCustomerEntity(customer)));
//    }
}
