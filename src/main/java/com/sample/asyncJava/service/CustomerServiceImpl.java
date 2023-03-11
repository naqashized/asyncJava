package com.sample.asyncJava.service;

import com.sample.asyncJava.dtos.CustomerRecord;
import com.sample.asyncJava.models.Customer;
import com.sample.asyncJava.repository.CustomerRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@Service
@AllArgsConstructor
public class CustomerServiceImpl implements CustomerService {
    private final CustomerRepository customerRepository;

    @Override
    public Flux<CustomerRecord> findAllCustomers() {
        return customerRepository.findAll().map(customer -> new CustomerRecord(customer.getId(),customer.getName(),
                customer.getAddress()));
    }

    @Override
    public Mono<CustomerRecord> findCustomer(String id) {
        Mono<Customer> customerMono = customerRepository.findById(id);
        return customerMono.map(customer -> new CustomerRecord(customer.getId(),customer.getName(),
                customer.getAddress()));
    }
}
