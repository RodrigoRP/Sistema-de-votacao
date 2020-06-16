package com.rodrigoramos.sistemavotacaoapi.converter;

import com.rodrigoramos.sistemavotacaoapi.dto.CustomerDTO;
import com.rodrigoramos.sistemavotacaoapi.dto.CustomerResponse;
import com.rodrigoramos.sistemavotacaoapi.entity.Customer;
import org.springframework.stereotype.Service;

@Service
public class CustomerConverter {

    public Customer asEntity(CustomerDTO dto) {
        return new Customer(null, dto.getFirstName(), dto.getLastName(), dto.getCpf());
    }

    public CustomerDTO asDTO(Customer customer) {
        return new CustomerDTO(customer.getFirstName(), customer.getFirstName(), customer.getLastName());
    }

    public CustomerResponse convertToResponseDto(Customer customer) {
        return new CustomerResponse(customer.getFirstName(), customer.getLastName());
    }

}
