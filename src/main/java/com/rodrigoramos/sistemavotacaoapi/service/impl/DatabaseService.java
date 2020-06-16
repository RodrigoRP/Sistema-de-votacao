package com.rodrigoramos.sistemavotacaoapi.service.impl;

import com.rodrigoramos.sistemavotacaoapi.dao.CustomerRepository;
import com.rodrigoramos.sistemavotacaoapi.dao.RestaurantRepository;
import com.rodrigoramos.sistemavotacaoapi.entity.Customer;
import com.rodrigoramos.sistemavotacaoapi.entity.Restaurant;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.Arrays;

@AllArgsConstructor
@Service
public class DatabaseService {

    private CustomerRepository customerRepository;
    private RestaurantRepository restaurantRepository;

    public void instantiateDataBase() {
        Customer c1 = new Customer(null, "Maria", "da Silva", "123123");
        Customer c2 = new Customer(null, "Jardel", "Fonseca", "12312");
        Customer c3 = new Customer(null, "Luis", "Nunes", "1231");
        Customer c4 = new Customer(null, "Martha", "Medeiros", "1231");

        Restaurant r1 = new Restaurant(null, "Sierra", 323, "Presidente Vargas", "Bonfim");
        Restaurant r2 = new Restaurant(null, "Serve Bem", 5675, "Medianeira", "Centro");

        customerRepository.saveAll(Arrays.asList(c1, c2, c3, c4));
        restaurantRepository.saveAll(Arrays.asList(r1, r2));


    }
}
