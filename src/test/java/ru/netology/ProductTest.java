package ru.netology;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class ProductTest {

    @Test
    public void shouldMatchProductByName() {
        Product product = new Product(1, "iPhone", 1000);
        assertTrue(product.matches("iPhone"));
    }

    @Test
    public void shouldMatchProductByPartialName() {
        Product product = new Product(1, "iPhone 15 Pro", 1200);
        assertTrue(product.matches("iPhone"));
    }

    @Test
    public void shouldNotMatchProductWhenSearchNotFound() {
        Product product = new Product(1, "iPhone", 1000);
        assertFalse(product.matches("Samsung"));
    }

    @Test
    public void shouldNotMatchProductWhenSearchIsNull() {
        Product product = new Product(1, "iPhone", 1000);
        assertFalse(product.matches(null));
    }

    @Test
    public void shouldNotMatchProductWhenSearchIsEmpty() {
        Product product = new Product(1, "iPhone", 1000);
        assertFalse(product.matches(""));
    }
}

