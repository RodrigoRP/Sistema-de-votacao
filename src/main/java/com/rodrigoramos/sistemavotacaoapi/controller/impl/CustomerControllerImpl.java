package com.rodrigoramos.sistemavotacaoapi.controller.impl;

import com.rodrigoramos.sistemavotacaoapi.controller.CustomerController;
import com.rodrigoramos.sistemavotacaoapi.converter.CustomerConverter;
import com.rodrigoramos.sistemavotacaoapi.dto.CustomerDTO;
import com.rodrigoramos.sistemavotacaoapi.entity.Customer;
import com.rodrigoramos.sistemavotacaoapi.service.CustomerService;
import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.net.URI;
import java.util.List;

@AllArgsConstructor
@RequestMapping("/api/customer")
@RestController
public class CustomerControllerImpl implements CustomerController {

    private final CustomerService customerService;
    private final CustomerConverter customerConverter;

    @Override
    @PostMapping("/")
    public ResponseEntity<Customer> save(@RequestBody CustomerDTO customerDTO) {
        Customer customer = customerConverter.asEntity(customerDTO);
        customerService.save(customer);

        URI uri = ServletUriComponentsBuilder.fromCurrentRequest()
                .path("/{id}").buildAndExpand(customer.getId()).toUri();

        return ResponseEntity.created(uri).body(customer);
    }

    @Override
    @GetMapping("/{id}")
    public ResponseEntity<Customer> findById(@PathVariable("id") Long id) {
        Customer customer = customerService.findById(id);
        return ResponseEntity.ok().body(customer);
    }

    @Override
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable("id") Long id) {
        customerService.deleteById(id);
        return ResponseEntity.noContent().build();
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