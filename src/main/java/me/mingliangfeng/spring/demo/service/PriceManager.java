package me.mingliangfeng.spring.demo.service;

import java.math.BigDecimal;
import java.util.List;

public interface PriceManager {

    public BigDecimal calculatePrice(List<RegistarInfo> registrations);

}
