package com.epam.rd.miamiw.controller;

import com.epam.rd.miamiw.model.WeatherEntity;
import com.epam.rd.miamiw.service.WeatherService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/")
public class WeatherController {

    @Autowired
    private WeatherService weatherService;

    @GetMapping
    public String getMiamiWeather(Model model) {
        WeatherEntity miamiTemperature = weatherService.getMiamiWeather();
        model.addAttribute("temperature", miamiTemperature.getTemperature());
        return "index";
    }
}
