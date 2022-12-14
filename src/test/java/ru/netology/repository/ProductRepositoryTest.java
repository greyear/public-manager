package ru.netology.repository;

import org.junit.jupiter.api.Test;
import ru.netology.domain.Book;
import ru.netology.domain.Product;
import ru.netology.domain.Smartphone;

import static org.junit.jupiter.api.Assertions.*;

class ProductRepositoryTest {

    Product[] testProducts = {
            new Book(1, "Lolita", 1254, "Vladimir Nabokov"),
            new Smartphone(2, "12 Lite 8", 39000, "Xiaomi"),
            new Smartphone(3, "Redmi 10A 2", 10000, "Xiaomi"),
            new Book(4, "1984", 1360, "George Orwell"),
            new Book(5, "Animal Farm", 1076, "George Orwell"),
            new Smartphone(6, "Galaxy A33 5G 6", 28000, "Samsung"),
            new Book(7, "Ulysses", 2831, "James Joyce"),
    };

    @Test
    public void saveAndFindAllTest() {
        ProductRepository repo = new ProductRepository();
        for (Product testProduct : testProducts) {
            repo.save(testProduct);
        }

        Product[] actual = repo.findAll();
        Product[] expected = {testProducts[0], testProducts[1], testProducts[2],
                              testProducts[3], testProducts[4], testProducts[5],
                              testProducts[6]};
        assertArrayEquals(expected, actual);
    }

    @Test
    public void removeByIdTest() {
        ProductRepository repo = new ProductRepository();
        for (Product testProduct : testProducts) {
            repo.save(testProduct);
        }
        repo.removeById(5);
        Product[] actual = repo.findAll();
        Product[] expected = {testProducts[0], testProducts[1], testProducts[2],
                              testProducts[3], testProducts[5], testProducts[6]};
        assertArrayEquals(expected, actual);
    }



}