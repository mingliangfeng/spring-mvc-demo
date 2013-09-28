package me.mingliangfeng.spring.demo.service.impl;

import java.math.BigDecimal;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

import me.mingliangfeng.spring.demo.dao.PriceCategoryDAO;
import me.mingliangfeng.spring.demo.entity.PriceCategory;
import me.mingliangfeng.spring.demo.service.PriceManager;
import me.mingliangfeng.spring.demo.service.RegistarInfo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class PriceManagerImpl implements PriceManager {
	
	@Autowired
    private PriceCategoryDAO priceCategoryDAO;

	@Override
	public BigDecimal calculatePrice(List<RegistarInfo> registrations) {
		if (registrations == null) return BigDecimal.ZERO;
		
		Map<PriceCategory, RegistarInfo> priceCategories = new HashMap<PriceCategory, RegistarInfo>();
		for (Iterator<RegistarInfo> it = registrations.iterator(); it.hasNext();) {
			RegistarInfo registarInfo = it.next();
			PriceCategory priceCategory = findPriceCategory(registarInfo);
			if (priceCategory != null) priceCategories.put(priceCategory, registarInfo);
		}
		return sumPrice(priceCategories);
	}

	PriceCategory findPriceCategory(RegistarInfo registarInfo) {
		PriceCategory priceCategory = priceCategoryDAO.findByName(registarInfo.getFullName());
		if (priceCategory == null) priceCategory = priceCategoryDAO.findByName(registarInfo.getDomainZone());
		return priceCategory;
	}

	BigDecimal sumPrice(Map<PriceCategory, RegistarInfo> priceCategories) {
		BigDecimal finalResult = BigDecimal.ZERO;
		for (Iterator<PriceCategory> it = priceCategories.keySet().iterator(); it.hasNext();) {
			PriceCategory priceCategory = it.next();
			RegistarInfo registarInfo = priceCategories.get(priceCategory);
			BigDecimal domainPrice = priceCategory.getPrice().multiply(new BigDecimal(registarInfo.getRegisterYear()));
			finalResult = finalResult.add(domainPrice);
		}
		return finalResult;
	}

}