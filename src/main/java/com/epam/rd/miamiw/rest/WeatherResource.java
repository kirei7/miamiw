package com.epam.rd.miamiw.rest;

import com.epam.rd.miamiw.service.WeatherService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.math.BigDecimal;

@RestController
@RequestMapping("/miami")
public class WeatherResource {

    @Autowired
    private WeatherService weatherService;

    @RequestMapping()
    public BigDecimal getMiamiTemperature() {
        return weatherService.getMiamiTemperature();
    }
}
