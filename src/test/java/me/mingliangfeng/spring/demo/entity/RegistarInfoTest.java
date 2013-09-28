package me.mingliangfeng.spring.demo.entity;

import static org.junit.Assert.*;

import me.mingliangfeng.spring.demo.service.RegistarInfo;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;


@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = { "/application-context.xml" })
public class RegistarInfoTest {
	
	@Test
    public void getDomainZone() {
		RegistarInfo domainName = new RegistarInfo("google.com", 1);
        assertEquals(domainName.getDomainZone(), ".com");
        
        domainName.setFullName("ausregistry.com.au");
        assertEquals(domainName.getDomainZone(), ".com.au");
    }
	
	@Test
    public void getFormatedFullName() {
		RegistarInfo registarInfo1 = new RegistarInfo("apple.com.au", 1);
		assertEquals(registarInfo1.getFormatedFullName(), "apple.com.au");
		
		RegistarInfo registarInfo2 = new RegistarInfo("AppLe.com.au", 1);
		assertEquals(registarInfo2.getFormatedFullName(), "apple.com.au");
		
		RegistarInfo registarInfo3 = new RegistarInfo("  Apple.com.au ", 1);
		assertEquals(registarInfo3.getFormatedFullName(), "apple.com.au");
		
		RegistarInfo registarInfo4 = new RegistarInfo("  App le.com.au ", 1);
		assertEquals(registarInfo4.getFormatedFullName(), "apple.com.au");
    }

}
