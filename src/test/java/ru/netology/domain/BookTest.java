package ru.netology.domain;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class BookTest {
    Book testBook1 = new Book(1, "Lolita", 1254, "Vladimir Nabokov");
    Book testBook2 = new Book(4, "1984", 1360, "George Orwell");

    @Test
    public void matchesTest() {
        assertTrue(testBook1.matches("Lol"));
    }

    @Test
    public void noMatchesTest() {
        assertFalse(testBook2.matches("Lol"));
    }

    @Test
    public void matchesAuthorTest() {
        assertTrue(testBook1.matches("Nab"));
    }
}