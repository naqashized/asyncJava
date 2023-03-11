package com.sample.asyncJava.service;

import com.sample.asyncJava.dtos.CustomerRecord;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

public interface CustomerService {
    Flux<CustomerRecord> findAllCustomers();
    Mono<CustomerRecord> findCustomer(String id);
}
