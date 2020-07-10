package ru.netology.manager;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import ru.netology.domain.Book;
import ru.netology.domain.Product;
import ru.netology.domain.Smartphone;
import ru.netology.repository.ProductRepository;

import static org.junit.jupiter.api.Assertions.*;

class ProductManagerTest {
    private ProductRepository repository = new ProductRepository();
    private ProductManager manager = new ProductManager(repository);

    private Product book1 = new Book(12, "Dune", 1400, "Herbert");
    private Product book2 = new Book(57, "Neuromancer", 1200, "Gibson");
    private Product phone1 = new Smartphone(14, "One", 17000, "OnePlus");
    private Product phone2 = new Smartphone(352, "Two", 22000, "OnePlus");
    private Product phone3 = new Smartphone(1120, "Three", 29000, "OnePlus");
    private Product product1 = new Product(2068, "Anything", 1900);

    @BeforeEach
    void setUp() {
        manager.add(book1);
        manager.add(phone1);
        manager.add(product1);
        manager.add(phone2);
        manager.add(book2);
        manager.add(phone3);
    }

    @Test
    void shouldReturnPhone1Name() {
        Product[] actual = manager.searchBy("One");
        Product[] expected = new Product[]{phone1};

        assertArrayEquals(expected, actual);
    }

    @Test
    void shouldReturnPhone2Name() {
        Product[] actual = manager.searchBy("Two");
        Product[] expected = new Product[]{phone2};

        assertArrayEquals(expected, actual);
    }

    @Test
    void shouldReturnPhone3Name() {
        Product[] actual = manager.searchBy("Three");
        Product[] expected = new Product[]{phone3};

        assertArrayEquals(expected, actual);
    }

    @Test
    void shouldReturnVendorPhones() {
        Product[] actual = manager.searchBy("OnePlus");
        Product[] expected = new Product[]{phone1, phone2, phone3};

        assertArrayEquals(expected, actual);
    }

    @Test
    void shouldReturnAuthorBook1() {
        Product[] actual = manager.searchBy("Herbert");
        Product[] expected = new Product[]{book1};

        assertArrayEquals(expected, actual);
    }

    @Test
    void shouldReturnAuthorBook2() {
        Product[] actual = manager.searchBy("Gibson");
        Product[] expected = new Product[]{book2};

        assertArrayEquals(expected, actual);
    }

    @Test
    void shouldReturnNameBook1() {
        Product[] actual = manager.searchBy("Dune");
        Product[] expected = new Product[]{book1};

        assertArrayEquals(expected, actual);
    }

    @Test
    void shouldReturnNameBook2() {
        Product[] actual = manager.searchBy("Neuromancer");
        Product[] expected = new Product[]{book2};

        assertArrayEquals(expected, actual);
    }

    @Test
    void shouldReturnNothing() {
        Product[] actual = manager.searchBy("Ghost in the Shell");
        Product[] expected = new Product[0];

        assertArrayEquals(expected, actual);
    }

}