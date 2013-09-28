package me.mingliangfeng.spring.demo.dao;

import me.mingliangfeng.spring.demo.entity.PriceCategory;


public interface PriceCategoryDAO {
	
	public PriceCategory findByName(String name);
	
}

