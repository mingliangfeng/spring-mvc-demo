package me.mingliangfeng.spring.demo.dao;

import static org.junit.Assert.*;
import me.mingliangfeng.spring.demo.entity.PriceCategory;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = { "/application-context.xml" })
public class PriceCategoryDAOTest {
	@Autowired
	private PriceCategoryDAO priceCategoryDAO;
	
	@Test
	public void findByName() {
		assertNull(priceCategoryDAO.findByName(null));
		assertNull(priceCategoryDAO.findByName(""));
		
		String[] categories = new String[] { ".com.au", ".net.au", ".org.au", ".com", ".net", ".org" };
		for (int i = 0; i < categories.length; i++) {
			PriceCategory priceCategory = priceCategoryDAO.findByName(categories[i]);
			assertNotNull(priceCategory);
		}
		
		PriceCategory priceCategory1 = priceCategoryDAO.findByName("apple.com.au");
		assertNotNull(priceCategory1);
		PriceCategory priceCategory2 = priceCategoryDAO.findByName("AppLe.com.au");
		assertNotNull(priceCategory2);
		PriceCategory priceCategory3 = priceCategoryDAO.findByName("  Apple.com.au ");
		assertNotNull(priceCategory3);
		PriceCategory priceCategory4 = priceCategoryDAO.findByName("  App le.com.au ");
		assertNotNull(priceCategory4);
		
		assertEquals(priceCategory1.getPrice(), priceCategory2.getPrice());
		assertEquals(priceCategory2.getPrice(), priceCategory3.getPrice());
		assertEquals(priceCategory3.getPrice(), priceCategory4.getPrice());
		
	}
}
