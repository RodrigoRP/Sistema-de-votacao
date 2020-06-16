package com.rodrigoramos.sistemavotacaoapi.controller.impl;

import com.rodrigoramos.sistemavotacaoapi.controller.CustomerController;
import com.rodrigoramos.sistemavotacaoapi.converter.CustomerConverter;
import com.rodrigoramos.sistemavotacaoapi.dto.CustomerDTO;
import com.rodrigoramos.sistemavotacaoapi.entity.Customer;
import com.rodrigoramos.sistemavotacaoapi.service.CustomerService;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@AllArgsConstructor
@RequestMapping("/api/customer")
@RestController
public class CustomerControllerImpl implements CustomerController {

    private final CustomerService customerService;
    private final CustomerConverter customerConverter;

    @Override
    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public CustomerDTO save(@RequestBody CustomerDTO customerDTO) {
        Customer customer = customerConverter.asEntity(customerDTO);
        return customerConverter.asDTO(customerService.save(customer));
    }

    @Override
    @GetMapping("/{id}")
    public CustomerDTO findById(@PathVariable("id") Long id) {
        Customer customer = customerService.findById(id).orElse(null);
        return customerConverter.asDTO(customer);
    }

    @Override
    @DeleteMapping("/{id}")
    public void delete(@PathVariable("id") Long id) {
        customerService.deleteById(id);
    }

    @Override
    @GetMapping
    public List<Customer> list() {
        return customerService.findAll();
    }

    @Override
    @PutMapping("/{id}")
    public CustomerDTO update(@RequestBody CustomerDTO customerDTO, @PathVariable("id") Long id) {
        Customer customer = customerConverter.asEntity(customerDTO);
        return customerConverter.asDTO(customerService.update(customer, id));
    }
}