package com.rodrigoramos.sistemavotacaoapi.service.impl;

import com.rodrigoramos.sistemavotacaoapi.dao.CustomerRepository;
import com.rodrigoramos.sistemavotacaoapi.entity.Customer;
import com.rodrigoramos.sistemavotacaoapi.service.CustomerService;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;
import java.util.Optional;

@Service
@Transactional
public class CustomerServiceImpl implements CustomerService {
    private final CustomerRepository repository;

    public CustomerServiceImpl(CustomerRepository repository) {
        this.repository = repository;
    }

    @Override
    public Customer save(Customer entity) {
        return repository.save(entity);
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
    public Optional<Customer> findById(Long id) {
        return repository.findById(id);
    }

    @Override
    public List<Customer> findAll() {
        return (List<Customer>) repository.findAll();
    }


    @Override
    public Customer update(Customer entity, Long id) {
        Optional<Customer> optional = findById(id);
        if (optional.isPresent()) {
            return save(entity);
        }
        return null;
    }
}