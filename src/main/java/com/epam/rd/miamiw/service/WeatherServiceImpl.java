package com.epam.rd.miamiw.service;

import com.epam.rd.miamiw.dao.OWAConstants;
import com.epam.rd.miamiw.dao.RemoteApiManager;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.util.Map;

@Service
public class WeatherServiceImpl implements WeatherService {

    public static final String CITY_NAME = "Miami";

    @Autowired
    private RemoteApiManager remoteApiManager;

    @Loggable
    @Override
    public BigDecimal getMiamiTemperature() {
        return getTemperatureByCity(CITY_NAME, Units.METRIC);
    }

    @Override
    public BigDecimal getTemperatureByCity(String cityName, Units units) {
        var requestParams = Map.of(
                OWAConstants.CITY_NAME, cityName,
                OWAConstants.UNITS, units.name()
        );
        return remoteApiManager.getWeather(requestParams).getTemperature();
    }
}
