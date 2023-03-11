package com.sample.asyncJava.repository;

import com.sample.asyncJava.models.Customer;
import org.springframework.data.mongodb.repository.ReactiveMongoRepository;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

public interface CustomerRepository extends ReactiveMongoRepository<Customer, String> {
    Mono<Customer> findAllByName(String name);
    Flux<Customer> findAll();
}
