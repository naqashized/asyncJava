package com.sample.asyncJava.web;

import com.sample.asyncJava.dtos.CustomerRecord;
import com.sample.asyncJava.service.CustomerService;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;


@RestController
@RequestMapping("/customers")
@AllArgsConstructor
public class CustomerController {
    private final CustomerService customerService;

    @GetMapping("")
    public Flux<CustomerRecord> findCustomers(){
        return customerService.findAllCustomers();
    }

    @GetMapping("/{id}")
    public Mono<CustomerRecord> findCustomer(@PathVariable String id){
        return customerService.findCustomer(id);
    }
}
