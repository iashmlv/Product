package ru.netology.domain;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class ProductTest {

    private Product book1 = new Book(12, "Dune", 1400, "Herbert");
    private Product phone1 = new Smartphone(14, "One", 17000, "OnePlus");
    private Product product1 = new Product(2068, "Anything", 1900);

    @Test
    void matchesCorrectBookName() {
        boolean actual = book1.matches("Dune");
        assertTrue(actual);
    }

    @Test
    void matchesIncorrectBookName() {
        boolean actual = book1.matches("Children of the Dune");
        assertFalse(actual);
    }

    @Test
    void matchesCorrectPhoneName() {
        boolean actual = phone1.matches("One");
        assertTrue(actual);
    }

    @Test
    void matchesIncorrectPhoneName() {
        boolean actual = phone1.matches("XOne");
        assertFalse(actual);
    }

    @Test
    void matchesCorrectPhoneVendor() {
        boolean actual = phone1.matches("OnePlus");
        assertTrue(actual);
    }

    @Test
    void matchesIncorrectPhoneVendor() {
        boolean actual = phone1.matches("Oppo");
        assertFalse(actual);
    }

    @Test
    void matchesCorrectProductName() {
        boolean actual = product1.matches("Anything");
        assertTrue(actual);
    }

    @Test
    void matchesIncorrectProductName() {
        boolean actual = product1.matches("Everything");
        assertFalse(actual);
    }

    @Test
    void matchesCorrectAuthor() {
        boolean actual = book1.matches("Herbert");
        assertTrue(actual);
    }

    @Test
    void matchesIncorrectAuthor() {
        boolean actual = book1.matches("Gibson");
        assertFalse(actual);
    }





}