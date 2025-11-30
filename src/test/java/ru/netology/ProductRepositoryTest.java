package ru.netology;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class ProductRepositoryTest {

    @Test
    public void CheckSaveAndFindAll() {
        ProductRepository productRepository = new ProductRepository();

        Product item1 = new Product(1, "книга Гарри Поттер Том1", 500);
        Product item2 = new Product(2, "Iphone", 1000);
        Product item3 = new Product(3, "Игрушка мягкая", 300);

        productRepository.save(item1);
        productRepository.save(item2);
        productRepository.save(item3);

        Product[] expected = {item1, item2, item3};
        Product[] actual = productRepository.findAll();

        assertArrayEquals(expected, actual);
    }

    @Test
    public void save() {
        ProductRepository repo = new ProductRepository();
        Product item1 = new Product(1, "книга Гарри Поттер", 500);
        repo.save(item1);

        assertEquals(item1, repo.findById(1));
        assertNull(repo.findById(999));
    }

    @Test
    void findById() {
        ProductRepository repo = new ProductRepository();
        Product item2 = new Product(2, "Iphone", 1000);
        repo.save(item2);

        assertEquals(item2, repo.findById(2));
    }


    @Test
    public void removeById() {
        ProductRepository repo = new ProductRepository();
        Product item1 = new Product(1, "книга Гарри Поттер Том1", 500);
        Product item2 = new Product(2, "Iphone", 1000);
        Product item3 = new Product(3, "Игрушка мягкая", 300);

        repo.save(item1);
        repo.save(item2);
        repo.save(item3);

        repo.removeById(2);
        Product[] expected = {item1, item3};
        assertArrayEquals(expected, repo.findAll());
    }

}
