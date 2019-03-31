package com.epam.rd.miamiw.dao;

import lombok.Getter;

import java.math.BigDecimal;

@Getter
public class OWAResponse {

    Main main;
    String name;

    @Getter
    static class Main {
        BigDecimal temp;
    }
}
