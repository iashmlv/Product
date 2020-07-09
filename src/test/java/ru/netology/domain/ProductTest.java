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

}