package com.mettalica.model.dto;

import lombok.Data;

import java.math.BigDecimal;

@Data
public class MarketDataDTO  {

	private String commodityCode;
	private BigDecimal price;

	public String getCommodityCode() {
		return commodityCode;
	}

	public void setCommodityCode(String commodityCode) {
		this.commodityCode = commodityCode;
	}

	public BigDecimal getPrice() {
		return price;
	}

	public void setPrice(BigDecimal price) {
		this.price = price;
	}
}
