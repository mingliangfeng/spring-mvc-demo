package me.mingliangfeng.spring.demo.controller;

import java.text.DateFormat;
import java.util.Date;
import java.util.Locale;

import me.mingliangfeng.spring.demo.service.PriceManager;
import me.mingliangfeng.spring.demo.service.RegistarInfo;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

/**
 * Handles requests for the application home page.
 */
@Controller
public class HomeController {
	
	private static final Logger logger = LoggerFactory.getLogger(HomeController.class);
	
	@Autowired
	private PriceManager priceManager;
	
	/**
	 * Simply selects the home view to render by returning its name.
	 */
	@RequestMapping(value = "/", method = RequestMethod.GET)
	public ModelAndView home() {
		logger.info("home action");
		
		RegistarForm domainNameForm = new RegistarForm();
		domainNameForm.getRegistarInfos().add(new RegistarInfo("", 1));
		
		return new ModelAndView("home", "registarForm", domainNameForm);
	}
	
	@RequestMapping(value = "/price", method = RequestMethod.GET)
	public ModelAndView price(@ModelAttribute("registarForm") RegistarForm domainNameForm) {
		logger.info("price action");
		
		ModelAndView modelAndView = new ModelAndView("home", "registarForm", domainNameForm);
		modelAndView.addObject("totalPrice", priceManager.calculatePrice(domainNameForm.getRegistarInfos()));
		
		return modelAndView;
	}
	
}
