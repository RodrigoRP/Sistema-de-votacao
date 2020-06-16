package com.rodrigoramos.sistemavotacaoapi.dao;

import com.rodrigoramos.sistemavotacaoapi.entity.Customer;
import com.rodrigoramos.sistemavotacaoapi.entity.Restaurant;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface RestaurantRepository extends PagingAndSortingRepository<Restaurant, Long> {

}