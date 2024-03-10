package com.qi.exchangerates.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;

@JsonIgnoreProperties(ignoreUnknown = true)
@Entity
@Table(name = "exchangerates")
public class ExchangeRates {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	@JsonProperty("Date")
	private String date;
	@JsonProperty("USD/NTD")
	private String usdtontd;
	@JsonProperty("RMB/NTD")
	private String rmbtontd;
	@JsonProperty("USD/RMB")
	private String usdtormb;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getDate() {
		return date;
	}

	public void setDate(String date) {
		this.date = date;
	}

	public String getUsdtontd() {
		return usdtontd;
	}

	public void setUsdtontd(String usdtontd) {
		this.usdtontd = usdtontd;
	}

	public String getRmbtontd() {
		return rmbtontd;
	}

	public void setRmbtontd(String rmbtontd) {
		this.rmbtontd = rmbtontd;
	}

	public String getUsdtormb() {
		return usdtormb;
	}

	public void setUsdtormb(String usdtormb) {
		this.usdtormb = usdtormb;
	}

}
