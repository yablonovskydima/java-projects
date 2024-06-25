package org.example;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class CalculatorTest {


    static  Calculator calculator;
    @BeforeAll
    static  void  setup()
    {
        calculator = new Calculator();
    }

    @Test
    void addition()
    {
        assertEquals(361816, calculator.addition(237834, 123982));
        assertEquals(291, calculator.addition(239, 52));
    }

    @Test
    void subtraction() {
        assertEquals(120800, calculator.subtraction(123123, 2323));
        assertEquals(111, calculator.subtraction(222, 111));
    }

    @Test
    void multiplication() {
        assertEquals(559035, calculator.multiplication(123, 4545));
        assertEquals(500, calculator.multiplication(100, 5));
    }

    @Test
    void division() {
        assertThrows(IllegalArgumentException.class, ()->calculator.division(1,0));
        assertEquals(1086, calculator.division(23892, 22));
        assertEquals(7, calculator.division(21, 3));
    }

    @Test
    void greaterThan() {
        assertEquals(5, calculator.greaterThan(5,3));
        assertEquals(101, calculator.greaterThan(101,23));
    }

    @Test
    void smallerThan() {
        assertEquals(21, calculator.smallerThan(223,21));
        assertEquals(151, calculator.smallerThan(100000,151));
    }

    @Test
    void percent() {
        assertEquals(25, calculator.percent(100, 25));
        assertEquals(116, calculator.percent(232, 50));
    }

    @Test
    void pow() {

        assertThrows(IllegalArgumentException.class, ()->calculator.pow(1,-23));
        assertEquals(4, calculator.pow(2, 2));
        assertEquals(25, calculator.pow(5, 2));
    }


}