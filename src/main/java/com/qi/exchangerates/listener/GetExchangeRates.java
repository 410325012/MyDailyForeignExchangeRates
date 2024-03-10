package com.qi.exchangerates.listener;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import com.qi.exchangerates.service.ExchangeRatesService;

@Component
public class GetExchangeRates implements CommandLineRunner {

	@Autowired
	ExchangeRatesService exchangeRatesService;

	@Override
	public void run(String... args) throws Exception {
		exchangeRatesService.getFromOpenapi();
	}

}
