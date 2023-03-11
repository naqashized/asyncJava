package com.sample.asyncJava;

import com.sample.asyncJava.models.Customer;
import com.sample.asyncJava.repository.CustomerRepository;
import jakarta.annotation.PostConstruct;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Component;
import reactor.core.publisher.Mono;

@Component
@AllArgsConstructor
public class ApplicationInitializer {
    private final CustomerRepository customerRepository;
    @PostConstruct
    public void initiate(){
        Customer customer1 = new Customer();
        customer1.setName("Test");
        customer1.setAddress("Address ");

        Mono<Customer> customerMono = customerRepository.save(customer1);


        Customer customer2 = new Customer();
        customer2.setName("Test2");
        customer2.setAddress("Address2 ");

        Mono<Customer> customerMono2 = customerRepository.save(customer2);
        customerMono.subscribe();
        customerMono2.subscribe();
    }

}
