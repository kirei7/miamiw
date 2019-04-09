package com.epam.rd.miamiw.service;

import java.math.BigDecimal;

public interface WeatherService {
    BigDecimal getMiamiTemperature();
    BigDecimal getTemperatureByCity(String cityName, Units units);
}
