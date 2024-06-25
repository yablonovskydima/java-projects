package org.example;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class CurrencyConvertorTest {

    @Test
    void toDollar()
    {
        CurrencyConvertor c = new CurrencyConvertor(1200);
        assertEquals(32.85, c.toDollar(), 0.01);

    }

    @Test
    void toEuro()
    {
        CurrencyConvertor c = new CurrencyConvertor(20145);
        assertEquals(521.08, c.toEuro(), 0.01);
    }

    @Test
    void toPounds()
    {
        CurrencyConvertor c = new CurrencyConvertor(5613);
        assertEquals(126.61, c.toPounds(), 0.01);
    }

    @Test
    void toYen()
    {
        CurrencyConvertor c = new CurrencyConvertor(70231);
        assertEquals(292629.16, c.toYen(), 0.01);
    }
}