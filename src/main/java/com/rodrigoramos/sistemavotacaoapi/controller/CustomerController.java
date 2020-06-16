package com.rodrigoramos.sistemavotacaoapi.controller;

import com.rodrigoramos.sistemavotacaoapi.dto.CustomerDTO;
import com.rodrigoramos.sistemavotacaoapi.entity.Customer;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;

import java.util.List;

@Api(tags = "Customer API")
public interface CustomerController {
    @ApiOperation("Add new customer")
    public ResponseEntity<Customer> save(@RequestBody CustomerDTO customer);

    @ApiOperation("Find by Id")
    public ResponseEntity<Customer> findById(@PathVariable("id") Long id);

    @ApiOperation("Delete based on primary key")
    public ResponseEntity<Void> delete(@PathVariable("id") Long id);

    @ApiOperation("Find all customers")
    public List<Customer> list();

    @ApiOperation("Update one data")
    public CustomerDTO update(@RequestBody CustomerDTO dto, @PathVariable("id") Long id);
}