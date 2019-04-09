package com.epam.rd.miamiw.service;

import com.epam.rd.miamiw.dao.OWAConstants;
import com.epam.rd.miamiw.dao.RemoteApiManager;
import com.epam.rd.miamiw.model.WeatherEntity;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Map;

@Service
public class WeatherServiceImpl implements WeatherService {

    private static final String CITY_NAME = "Miami";

    @Autowired
    private RemoteApiManager remoteApiManager;


    @Override
    public WeatherEntity getMiamiWeather() {
        return getWeatherByCity(CITY_NAME, Units.METRIC);
    }

    @Override
    public WeatherEntity getWeatherByCity(String cityName, Units units) {
        var requestParams = Map.of(
                OWAConstants.CITY_NAME, cityName,
                OWAConstants.UNITS, units.name()
        );
        return remoteApiManager.getWeather(requestParams);
    }
}
