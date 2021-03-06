package com.rodrigoramos.sistemavotacaoapi.dao;

import com.rodrigoramos.sistemavotacaoapi.entity.Customer;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface CustomerRepository extends PagingAndSortingRepository<Customer, Long> {

    Optional<Customer> findCustomerByCpf(String cpf);

}