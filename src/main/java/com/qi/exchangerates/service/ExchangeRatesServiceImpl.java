package com.qi.exchangerates.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.client.RestTemplate;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.qi.exchangerates.model.ExchangeRates;
import com.qi.exchangerates.repository.ExchangeRatesRepository;
import com.qi.exchangerates.utils.SslUtils;

@Service
@Transactional
public class ExchangeRatesServiceImpl implements ExchangeRatesService {

	@Autowired
	RestTemplate restTemplate;

	@Autowired
	ExchangeRatesRepository exchangeRatesRepository;

	@Override
	public List<ExchangeRates> findAll() {
		return exchangeRatesRepository.findAll();
	}

	@Override
	public Optional<ExchangeRates> findById(Long id) {
		return exchangeRatesRepository.findById(id);
	}

	@Override
	public void deleteById(Long id) {
		exchangeRatesRepository.deleteById(id);
	}

	@Override
	public ExchangeRates save(ExchangeRates e) {
		return exchangeRatesRepository.save(e);
	}

	@Override
	public void getFromOpenapi() throws JsonMappingException, JsonProcessingException {
		try {
			SslUtils.ignoreSsl();
		} catch (Exception e) {
			e.printStackTrace();
		}
		String response = restTemplate.getForObject("https://openapi.taifex.com.tw/v1/DailyForeignExchangeRates",
				String.class);
		ObjectMapper mapper = new ObjectMapper();
		JsonNode rootNode = mapper.readValue(response, JsonNode.class);
		rootNode.forEach((node) -> {
			JsonNode date = node.get("Date");
			JsonNode usdtontd = node.get("USD/NTD");
			JsonNode rmbtontd = node.get("RMB/NTD");
			JsonNode usdtormb = node.get("USD/RMB");
			ExchangeRates exchangeRates = new ExchangeRates();
			exchangeRates.setDate(date.asText());
			exchangeRates.setUsdtontd(usdtontd.asText());
			exchangeRates.setRmbtontd(rmbtontd.asText());
			exchangeRates.setUsdtormb(usdtormb.asText());
			exchangeRatesRepository.save(exchangeRates);
		});
	}

}
