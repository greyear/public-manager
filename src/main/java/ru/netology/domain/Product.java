package ru.netology.domain;

import lombok.Data;
import lombok.Getter;
import lombok.Setter;

@Data
public class Product {
    private int id;
    private String name;
    private int price;

    public Product(int id, String name, int price) {
        this.id = id;
        this.name = name;
        this.price = price;
    }
}
