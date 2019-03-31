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

    @Override
    public BigDecimal getMiamiTemperature() {
        var requestParams = Map.of(
                OWAConstants.CITY_NAME, CITY_NAME,
                OWAConstants.UNITS, Units.METRIC.name()
        );
        return remoteApiManager.getWeather(requestParams).getTemperature();
    }
}
