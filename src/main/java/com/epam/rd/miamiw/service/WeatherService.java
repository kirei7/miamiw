package com.epam.rd.miamiw.service;

import com.epam.rd.miamiw.model.WeatherEntity;

public interface WeatherService {
    WeatherEntity getMiamiWeather();
    WeatherEntity getWeatherByCity(String cityName, Units units);
}
