package org.example;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

class GeomertyTest {

    @Test
    void squareS()
    {
        Geomerty g = new Geomerty(3);
        assertEquals(9.0, g.SquareS());
    }

    @Test
    void triangleS()
    {
        Geomerty g = new Geomerty(3);
        assertEquals(3.89, g.TriangleS(), 0.01);
    }

    @Test
    void rectangleS()
    {
        Geomerty g = new Geomerty(5.0, 10.0);
        assertEquals(50.0, g.RectangleS());
    }

    @Test
    void diamondS()
    {
        Geomerty g = new Geomerty(6.0, 4);
        assertEquals(24.0, g.diamondS());
    }
}