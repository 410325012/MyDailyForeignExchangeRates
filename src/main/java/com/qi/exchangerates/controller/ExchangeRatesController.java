package com.qi.exchangerates.controller;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import com.qi.exchangerates.model.ExchangeRates;
import com.qi.exchangerates.service.ExchangeRatesService;

import springfox.documentation.annotations.ApiIgnore;

@ApiIgnore
@Controller
public class ExchangeRatesController {

	@Autowired
	ExchangeRatesService exchangeRatesService;

	@GetMapping
	public String getMyDailyForeignExchangeRates(Model model) {
		model.addAttribute("exchangeRates", exchangeRatesService.findAll());
		return "table";
	}

	@PostMapping("/form")
	public String getMyDailyForeignExchangeRates2(Model model, Long id) {
		if (id != null) {
			Optional<ExchangeRates> exchangeRates = exchangeRatesService.findById(id);
			model.addAttribute("exchangeRates", exchangeRates);
		} else {
			ExchangeRates exchangeRates = new ExchangeRates();
			model.addAttribute("exchangeRates", exchangeRates);
		}
		return "form";
	}

	@PostMapping("/save")
	public String getMyDailyForeignExchangeRates3(ExchangeRates exchangeRates) {
		exchangeRatesService.save(exchangeRates);
		return "redirect:/";
	}

}
