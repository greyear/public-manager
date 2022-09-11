package ru.netology.manager;

import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import ru.netology.domain.Book;
import ru.netology.domain.Product;
import ru.netology.domain.Smartphone;
import ru.netology.repository.ProductRepository;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.doReturn;

class ProductManagerTest {
    private ProductRepository repo = Mockito.mock(ProductRepository.class);
    private Product[] testProducts = {
            new Book(1, "Lolita", 1254, "Vladimir Nabokov"),
            new Smartphone(2, "12 Lite 8", 39000, "Xiaomi"),
            new Smartphone(3, "Redmi 10A 2", 10000, "Xiaomi"),
            new Book(4, "1984", 1360, "George Orwell"),
            new Book(5, "Animal Farm", 1076, "George Orwell"),
            new Smartphone(6, "Galaxy A33 5G 6", 28000, "Samsung"),
            new Book(7, "Ulysses", 2831, "James Joyce")
    };

    @Test
    public void addTest() {
        ProductManager manager = new ProductManager(repo);
        manager.add(testProducts[0]);
        Mockito.verify(repo).save(testProducts[0]);
    }

    @Test
    public void matchesTest() {
        ProductManager manager = new ProductManager(repo);
        Product product = testProducts[0];
        assertTrue(manager.matches(product, "Lol"));
    }

    @Test
    public void noMatchesTest() {
        ProductManager manager = new ProductManager(repo);
        Product product = testProducts[0];
        assertFalse(manager.matches(product, "Lot"));
    }

    @Test
    public void searchByTest() {
        ProductManager manager = new ProductManager(repo);
        Product[] returned = {testProducts[0], testProducts[1], testProducts[2],
                              testProducts[3], testProducts[4], testProducts[5],
                              testProducts[6]};
        doReturn(returned).when(repo).findAll();
        Product[] actual = manager.searchBy("it");
        Product[] expected = {testProducts[0], testProducts[1]};
        assertArrayEquals(expected, actual);
    }

    @Test
    public void searchByNoResultTest() {
        ProductManager manager = new ProductManager(repo);
        Product[] returned = {testProducts[0], testProducts[1], testProducts[2],
                              testProducts[3], testProducts[4], testProducts[5],
                              testProducts[6]};
        doReturn(returned).when(repo).findAll();
        Product[] actual = manager.searchBy("it ");
        Product[] expected = {};
        assertArrayEquals(expected, actual);
    }

}