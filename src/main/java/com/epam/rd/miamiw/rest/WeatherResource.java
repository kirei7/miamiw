package com.epam.rd.miamiw.rest;

import com.epam.rd.miamiw.model.WeatherEntity;
import com.epam.rd.miamiw.service.WeatherService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/miami")
public class WeatherResource {

    @Autowired
    private WeatherService weatherService;

    @RequestMapping
    public WeatherEntity getMiamiTemperature() {
        return weatherService.getMiamiWeather();
    }

}
