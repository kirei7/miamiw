package com.epam.rd.miamiw.controller;

import com.epam.rd.miamiw.model.WeatherEntity;
import com.epam.rd.miamiw.service.Units;
import com.epam.rd.miamiw.service.WeatherService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

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

    @GetMapping("/{cityName}")
    public String getCityWeather(
            @PathVariable("cityName") String cityName,
            Model model,
            @RequestParam("units") String units
    ) {
        WeatherEntity miamiTemperature = weatherService.getWeatherByCity(
                cityName,
                Units.fromLiteral(units)
                );
        model.addAttribute("temperature", miamiTemperature.getTemperature());
        return "index";
    }
}
