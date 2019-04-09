package com.epam.rd.miamiw.model;

import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import org.springframework.util.StringUtils;

import java.math.BigDecimal;

@Builder
@Getter
@NoArgsConstructor
public class WeatherEntity {
    private String city;
    private BigDecimal temperature;

    public WeatherEntity(String city, BigDecimal temperature) {
        this.city = StringUtils.capitalize(city.toLowerCase());
        this.temperature = temperature;
    }
}
