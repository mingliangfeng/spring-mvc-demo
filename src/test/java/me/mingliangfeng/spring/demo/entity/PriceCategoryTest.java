package me.mingliangfeng.spring.demo.entity;

import static org.junit.Assert.*;

import java.math.BigDecimal;

import me.mingliangfeng.spring.demo.entity.PriceCategory;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = { "/application-context.xml" })
public class PriceCategoryTest {
	
	@Test
    public void isPremium() {
		PriceCategory priceCategory = new PriceCategory("google.com", BigDecimal.ONE);
        assertTrue(priceCategory.isPremiumCategory());
        
        priceCategory.setName(".com.au");
        assertFalse(priceCategory.isPremiumCategory());
    }

}
