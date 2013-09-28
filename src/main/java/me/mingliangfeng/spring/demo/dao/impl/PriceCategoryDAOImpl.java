package me.mingliangfeng.spring.demo.dao.impl;

import java.math.BigDecimal;
import java.util.Map;
import java.util.HashMap;

import me.mingliangfeng.spring.demo.dao.PriceCategoryDAO;
import me.mingliangfeng.spring.demo.entity.PriceCategory;
import me.mingliangfeng.spring.demo.util.Utils;

import org.springframework.stereotype.Component;

@Component
public class PriceCategoryDAOImpl implements PriceCategoryDAO {
	
	//TODO: fake DAO implementation, get data from static map directly,
	//      should be easy to switch to hibernate DAO
	private static Map<String, BigDecimal> priceTable = new HashMap<String, BigDecimal>();
	
	static {
		priceTable.put(".com.au", new BigDecimal(20));
		priceTable.put(".net.au", new BigDecimal(20));
		priceTable.put(".org.au", new BigDecimal(20));
		priceTable.put(".com", new BigDecimal(10));
		priceTable.put(".net", new BigDecimal(9));
		priceTable.put(".org", new BigDecimal(9));
		priceTable.put(".me ", new BigDecimal(9));
		
		priceTable.put("apple.com.au", new BigDecimal(1000));
		priceTable.put("dict.com", new BigDecimal(800));
		priceTable.put("education.net", new BigDecimal(300));
	}

	@Override
	public PriceCategory findByName(String name) {
		name = Utils.formatDomainName(name);
		if (!priceTable.containsKey(name)) return null;
		
		BigDecimal price = priceTable.get(name);
		return new PriceCategory(name, price);
	}

}

