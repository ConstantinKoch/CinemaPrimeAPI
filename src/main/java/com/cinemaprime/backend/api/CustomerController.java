package com.cinemaprime.backend.api;

import com.cinemaprime.backend.api.apimodels.Token;
import com.cinemaprime.backend.dao.CustomerRepository;
import com.cinemaprime.backend.dbmodels.usermodels.Customer;
import com.cinemaprime.backend.dbmodels.usermodels.Person;
import com.cinemaprime.backend.services.CustomerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

@RequestMapping("customer")
@RestController
public class CustomerController {

    @Autowired
    private CustomerService service;

    @PostMapping("/signup")
    public Token signup(@RequestBody Customer customer) {
        Customer customerExist = service.findCustomerByMail(customer.getEmail());
        if (customerExist != null) throw new CustomerExistException();

        return new Token(service.signup(customer));
    }

    @PostMapping("/login")
    public Token login(@RequestBody Customer customer) {
        return new Token(service.login(customer));
    }

    @PostMapping("/find")
    public HttpStatus find(@RequestBody Customer customer) {
        return service.findCustomerByMail(customer.getEmail()) != null ? HttpStatus.FOUND : HttpStatus.NOT_FOUND;
    }

    @GetMapping("/find/{token}")
    public Customer find(@PathVariable("token") Token token) {
        return service.find(token);
    }

}

@ResponseStatus(value = HttpStatus.CONFLICT, reason = "Email already found")
class CustomerExistException extends RuntimeException {}
