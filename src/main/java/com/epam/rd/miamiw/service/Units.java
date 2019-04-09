package com.epam.rd.miamiw.service;

public enum Units {
    METRIC, IMPERIAL;

    public static Units fromLiteral(String literal) {
        switch (literal.toLowerCase()) {
            case "i":
                return IMPERIAL;
            case "m":
            default:
                return METRIC;
        }
    }
}
