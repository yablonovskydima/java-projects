package org.example;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class CmConvertorTest {

    CmConvertor c = new CmConvertor(6123.2);
    @Test
    void toMM()
    {
        assertEquals(61232, c.toMM());
    }

    @Test
    void toCM()
    {
        assertEquals(6123.2, c.toCM());
    }

    @Test
    void toDM()
    {
        assertEquals(612.32, c.toDM(), 0.001);
    }

    @Test
    void toMeters()
    {
        assertEquals(61.232, c.toMeters());
    }

    @Test
    void toKM()
    {
        assertEquals(0.061232, c.toKM(), 0.0001);
    }
}