package com.qi.exchangerates.service;

import java.util.List;
import java.util.Optional;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.qi.exchangerates.model.ExchangeRates;

public interface ExchangeRatesService {

	void getFromOpenapi() throws JsonMappingException, JsonProcessingException;

	List<ExchangeRates> findAll();

	void deleteById(Long id);

	Optional<ExchangeRates> findById(Long id);

	ExchangeRates save(ExchangeRates e);

}
