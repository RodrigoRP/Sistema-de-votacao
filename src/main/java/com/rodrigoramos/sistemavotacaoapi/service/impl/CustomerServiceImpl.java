package com.rodrigoramos.sistemavotacaoapi.service.impl;

import com.rodrigoramos.sistemavotacaoapi.dao.CustomerRepository;
import com.rodrigoramos.sistemavotacaoapi.entity.Customer;
import com.rodrigoramos.sistemavotacaoapi.service.CustomerService;
import com.rodrigoramos.sistemavotacaoapi.service.exception.CustomerRegistrationException;
import com.rodrigoramos.sistemavotacaoapi.service.exception.ObjectNotFoundException;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;
import java.util.Optional;

@AllArgsConstructor
@Service
@Transactional
public class CustomerServiceImpl implements CustomerService {

    private final CustomerRepository repository;

    @Override
    public Customer save(Customer customer) {
        Optional<Customer> clienteOptional = repository.findCustomerByCpf(customer.getCpf());
        if (clienteOptional.isPresent()) {
            throw new CustomerRegistrationException("CPF:" + customer.getCpf() + " already exists");
        }

        return repository.save(customer);
    }

    @Override
    public List<Customer> save(List<Customer> entities) {
        return (List<Customer>) repository.saveAll(entities);
    }

    @Override
    public void deleteById(Long id) {
        repository.deleteById(id);
    }

    @Override
    public Customer findById(Long id) {
        Optional<Customer> optionalCustomer = repository.findById(id);
        return optionalCustomer.orElseThrow(() -> new ObjectNotFoundException(
                "Cliente não encontrado! Id: " + id + ", Tipo: " + Customer.class.getName()));
    }

    @Override
    public List<Customer> findAll() {
        return (List<Customer>) repository.findAll();
    }


    @Override
    public Customer update(Customer entity, Long id) {
        Optional<Customer> optional = Optional.ofNullable(findById(id));
        if (optional.isPresent()) {
            return save(entity);
        }
        return null;
    }
}