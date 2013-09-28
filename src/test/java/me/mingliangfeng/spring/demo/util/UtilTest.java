package me.mingliangfeng.spring.demo.util;

import static org.junit.Assert.*;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;


@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = { "/application-context.xml" })
public class UtilTest {
	
	@Test
    public void formatDomainName() {
        assertEquals(Utils.formatDomainName("AppLe.com.au"), "apple.com.au");
        assertEquals(Utils.formatDomainName("  Apple.com.au "), "apple.com.au");
        assertEquals(Utils.formatDomainName("  Apple.com.au "), "apple.com.au");
    }

}
