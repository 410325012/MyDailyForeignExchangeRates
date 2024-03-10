package com.qi.exchangerates.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.qi.exchangerates.model.ExchangeRates;
import com.qi.exchangerates.service.ExchangeRatesService;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;

@Api(tags = "MyDailyForeignExchangeRates相關API")
@RestController
@RequestMapping("v1")
public class ExchangeRatesRestController {

	@Autowired
	ExchangeRatesService exchangeRatesService;

	@ApiOperation("取得所有MyDailyForeignExchangeRates")
	@GetMapping("MyDailyForeignExchangeRates")
	public List<ExchangeRates> getMyDailyForeignExchangeRates() {
		return exchangeRatesService.findAll();
	}

	@ApiOperation("取得MyDailyForeignExchangeRates")
	@GetMapping("MyDailyForeignExchangeRates/{id}")
	public Optional<ExchangeRates> getMyDailyForeignExchangeRatesById(@PathVariable(value = "id") Long id) {
		return exchangeRatesService.findById(id);
	}

	@ApiOperation("新增MyDailyForeignExchangeRates")
	@PostMapping("MyDailyForeignExchangeRates")
	public ExchangeRates putMyCoinDeskByCode(String date, String usdtontd, String rmbtontd, String usdtormb) {
		ExchangeRates e = new ExchangeRates();
		e.setDate(date);
		e.setUsdtontd(usdtontd);
		e.setUsdtormb(usdtormb);
		e.setRmbtontd(rmbtontd);
		return exchangeRatesService.save(e);
	}

	@ApiOperation("修改MyDailyForeignExchangeRates")
	@PutMapping("MyDailyForeignExchangeRates/{id}")
	public ExchangeRates putMyCoinDeskByCode(@PathVariable(value = "id") Long id, String date, String usdtontd,
			String rmbtontd, String usdtormb) {
		ExchangeRates e = new ExchangeRates();
		e.setId(id);
		e.setDate(date);
		e.setUsdtontd(usdtontd);
		e.setUsdtormb(usdtormb);
		e.setRmbtontd(rmbtontd);
		return exchangeRatesService.save(e);
	}

	@ApiOperation("刪除MyDailyForeignExchangeRates")
	@DeleteMapping("MyDailyForeignExchangeRates/{id}")
	public void deleteMyDailyForeignExchangeRatesById(@PathVariable(value = "id") Long id) {
		exchangeRatesService.deleteById(id);
	}

}
