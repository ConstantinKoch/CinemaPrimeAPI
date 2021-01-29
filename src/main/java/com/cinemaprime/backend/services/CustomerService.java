package com.cinemaprime.backend.services;

import com.cinemaprime.backend.api.apimodels.Token;
import com.cinemaprime.backend.config.security.JwtTokenProvider;
import com.cinemaprime.backend.dao.CustomerRepository;
import com.cinemaprime.backend.dbmodels.usermodels.Customer;
import com.cinemaprime.backend.exceptions.CustomException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Component;

import java.util.Collections;
import java.util.List;

@Component
public class CustomerService implements UserDetailsService {
    @Autowired
    private CustomerRepository customerRepository;

    @Autowired
    private BCryptPasswordEncoder bCryptPasswordEncoder;

    @Autowired
    private JwtTokenProvider jwtTokenProvider;

    @Autowired
    private AuthenticationManager authenticationManager;

    @Override
    public UserDetails loadUserByUsername(String s) throws UsernameNotFoundException {
        Customer customer = customerRepository.findByEmail(s);

        if (customer == null) {
            throw new UsernameNotFoundException("Email not found");
        }

        List<GrantedAuthority> authorities = Collections.singletonList(new SimpleGrantedAuthority("USER"));

        return buildUserForAuthentication(customer, authorities);
    }

    public Customer findCustomerByMail(String mail) {
        return customerRepository.findByEmail(mail);
    }

    private UserDetails buildUserForAuthentication(Customer customer, List<GrantedAuthority> authorities) {
        return new org.springframework.security.core.userdetails.User(customer.getEmail(), customer.getPassword(), authorities);
    }

    public void saveCustomer(Customer customer) {
        customer.setPassword(bCryptPasswordEncoder.encode(customer.getPassword()));
        customerRepository.save(customer);
    }

    public String login(Customer customer) {
        try {
            authenticationManager.authenticate(new UsernamePasswordAuthenticationToken(customer.getEmail(), customer.getPassword()));
            return jwtTokenProvider.createToken(customer.getEmail());
        } catch (AuthenticationException e) {
            throw new CustomException("Invalid username/password supplied", HttpStatus.UNPROCESSABLE_ENTITY);
        }
    }

    public String signup(Customer customer) {
        if (findCustomerByMail(customer.getEmail()) == null) {
            return null;
        } else {
            saveCustomer(customer);
            return jwtTokenProvider.createToken(customer.getEmail());
        }
    }

    public String refresh(String email) {
        return jwtTokenProvider.createToken(email);
    }

    public Customer find(Token token) {
        return findCustomerByMail(jwtTokenProvider.getEmail(token.getToken()));
    }
}
