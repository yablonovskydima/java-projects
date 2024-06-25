package org.example;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class GramConvertorTest {

    GramConvertor g = new GramConvertor(52103);

    @Test
    void toMiligram()
    {
        assertEquals(52103000, g.toMiligram());
    }

    @Test
    void toKG()
    {
        assertEquals(52.103, g.toKG(), 0.001);
    }

    @Test
    void toCN()
    {
        assertEquals(0.52103, g.toCN(), 0.001);
    }

    @Test
    void toTN()
    {
        assertEquals(0.052103, g.toTN(), 0.001);
    }
}