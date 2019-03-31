package com.epam.rd.miamiw.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

import java.math.BigDecimal;

@Builder
@Getter
@AllArgsConstructor
public class WeatherEntity {
    String city;
    BigDecimal temperature;
}
