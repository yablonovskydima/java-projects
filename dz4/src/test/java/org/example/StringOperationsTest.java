package org.example;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class StringOperationsTest {

    @Test
    void isPalindrom()
    {
        StringOperations s = new StringOperations("abba");
        assertTrue(s.isPalindrom());
    }

    @Test
    void vowelCount()
    {
        StringOperations s = new StringOperations("verylongword");
        assertEquals(3, s.vowelCount());
    }

    @Test
    void consonantCount()
    {
        StringOperations s = new StringOperations("verylongword");
        assertEquals(9, s.consonantCount());
    }

    @Test
    void wordCount()
    {
        StringOperations s = new StringOperations("hey I love my phone , this phone is the best phone of all phones");
        assertEquals(3, s.wordCount("phone"));
    }
}