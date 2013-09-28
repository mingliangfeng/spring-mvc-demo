package me.mingliangfeng.spring.demo.service;

import static org.junit.Assert.assertEquals;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = { "/application-context.xml" })
public class PriceManagerTest {

	@Autowired
	private PriceManager priceManager;

	@Test
	public void calculatePrice() {
		List<RegistarInfo> registrations = new ArrayList<RegistarInfo>();
		registrations.add(new RegistarInfo("a-domain.com", 1));
		registrations.add(new RegistarInfo("another-domain.net", 2));
		registrations.add(new RegistarInfo("dict.com", 5));
		
		assertEquals(priceManager.calculatePrice(registrations), new BigDecimal(4028));
	}
}

