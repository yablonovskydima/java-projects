package org.example;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class NumManipulationsTest {

    @Test
    void get()
    {

    }

    @Test
    void set()
    {

    }

    @Test
    void toOcto() {
        NumManipulations man = new NumManipulations(16);
        assertEquals("20", man.toOcto());
    }

    @Test
    void toHex()
    {
        NumManipulations man = new NumManipulations(21);
        assertEquals("15", man.toHex());
    }

    @Test
    void toBinary()
    {
        NumManipulations man = new NumManipulations(64);
        assertEquals("1000000", man.toBinary());
    }
}