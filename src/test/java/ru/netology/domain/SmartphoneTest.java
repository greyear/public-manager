package ru.netology.domain;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class SmartphoneTest {
    Smartphone testSmartphone1 = new Smartphone(2, "12 Lite 8", 39000, "Xiaomi");
    Smartphone testSmartphone2 = new Smartphone(3, "Redmi 10A 2", 10000, "Xiaomi");

    @Test
    public void matchesTest() {
        assertTrue(testSmartphone1.matches("12"));
    }

    @Test
    public void noMatchesTest() {
        assertFalse(testSmartphone2.matches("12"));
    }

    @Test
    public void matchesProducerTest() {
        assertTrue(testSmartphone1.matches("Xiaomi"));
    }
}