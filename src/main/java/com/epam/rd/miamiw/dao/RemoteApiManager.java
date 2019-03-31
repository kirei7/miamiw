package com.epam.rd.miamiw.dao;

import com.epam.rd.miamiw.model.WeatherEntity;

import java.util.Map;

public interface RemoteApiManager {
    WeatherEntity getWeather(Map<String, String> reqParams);
}
