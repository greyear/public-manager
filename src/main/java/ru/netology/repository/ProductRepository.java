package ru.netology.repository;

import ru.netology.domain.Product;
import ru.netology.exception.AlreadyExistsException;
import ru.netology.exception.NotFoundException;

public class ProductRepository {
    private Product[] products = new Product[0];

    public void save(Product productAdded) {
        for (Product product : products) {
            if (product.getId() == productAdded.getId()) {
                throw new AlreadyExistsException("Element with id " + productAdded.getId() + " already exists");
            }
        }
        int length = products.length + 1;
        Product[] tmp = new Product[length];
        System.arraycopy(products, 0, tmp, 0, products.length);
        tmp[length - 1] = productAdded;
        products = tmp;
    }

    public Product[] findAll() {
        return products;
    }

    public Product findById(int id) {
        for (Product product : products) {
            if (product.getId() == id) return product;
        }
        return null;
    }

    public void removeById(int id) throws NotFoundException {
        if (products.length == 0) {
            throw new NotFoundException("There are no elements");
        }
        Product[] tmp = new Product[products.length - 1];
        int i = 0;
        Product productToDelete = findById(id);
        if (productToDelete == null) {
            throw new NotFoundException("Element with id: " + id + " not found");
        }
        for (Product product : products) {
            if (product.getId() != id) {
                tmp[i] = product;
                i++;
            }
        }
        products = tmp;
    }
}
