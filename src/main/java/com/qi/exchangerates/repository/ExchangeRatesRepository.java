package com.qi.exchangerates.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.qi.exchangerates.model.ExchangeRates;

public interface ExchangeRatesRepository extends JpaRepository<ExchangeRates, Long> {

}
