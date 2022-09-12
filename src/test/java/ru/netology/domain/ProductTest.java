package ru.netology.domain;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class ProductTest {
    Product testProduct1 = new Book(1, "Lolita", 1254, "Vladimir Nabokov");
    Product testProduct2 = new Smartphone(2, "12 Lite 8", 39000, "Xiaomi");

    @Test
    public void matchesTest() {
        assertTrue(testProduct1.matches("Lol"));
    }

    @Test
    public void noMatchesTest() {
        assertFalse(testProduct2.matches("Lol"));
    }

}