package me.mingliangfeng.spring.demo.entity;

import java.math.BigDecimal;

import org.springframework.util.StringUtils;

public class PriceCategory {
	private String name;
	private BigDecimal price;

	public PriceCategory() {
	}
	
	public PriceCategory(String name, BigDecimal price) {
		this.name = name;
		this.price = price;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public BigDecimal getPrice() {
		return price;
	}

	public void setPrice(BigDecimal price) {
		this.price = price;
	}

	public boolean isPremiumCategory() {
		return !StringUtils.startsWithIgnoreCase(getName(), ".");
	}
	
}
