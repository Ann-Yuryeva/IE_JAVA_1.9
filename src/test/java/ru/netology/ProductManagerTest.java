package ru.netology;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
public class ProductManagerTest {

    @Mock
    ProductRepository repo;

    @InjectMocks
    ProductManager manager;

    @Test
    public void shouldSave() {
        Product item = new Product(1, "Iphone", 1000);
        manager.add(item);
        verify(repo).save(item);
    }

    @Test
    public void shouldSearchByTextForProduct() {
        Product item1 = new Product(1, "iPhone", 1000);
        Product item2 = new Product(2, "Samsung", 800);
        Product item3 = new Product(3, "iPhone 15", 1200);

        when(repo.findAll()).thenReturn(new Product[]{item1, item2, item3});

        Product[] result = manager.searchBy("iPhone");

        assertEquals(2, result.length);
        assertEquals(item1, result[0]);
        assertEquals(item3, result[1]);
    }

    @Test
    public void shouldSearchByTextForBook() {
        Book book1 = new Book(1, "Гарри Поттер", 500, "Дж. Роулинг");
        Book book2 = new Book(2, "Война и мир", 600, "Л. Толстой");

        when(repo.findAll()).thenReturn(new Product[]{book1, book2});

        Product[] result = manager.searchBy("Роулинг");

        assertEquals(1, result.length);
        assertEquals(book1, result[0]);
    }

    @Test
    public void shouldSearchByTextForSmartphone() {
        Smartphone phone1 = new Smartphone(1, "iPhone 15", 1000, "Apple");
        Smartphone phone2 = new Smartphone(2, "Galaxy S24", 900, "Samsung");

        when(repo.findAll()).thenReturn(new Product[]{phone1, phone2});

        Product[] result = manager.searchBy("Apple");

        assertEquals(1, result.length);
        assertEquals(phone1, result[0]);
    }

    @Test
    public void shouldReturnEmptyArrayWhenNoMatches() {
        Product item1 = new Product(1, "iPhone", 1000);
        Product item2 = new Product(2, "Samsung", 800);

        when(repo.findAll()).thenReturn(new Product[]{item1, item2});

        Product[] result = manager.searchBy("Nokia");

        assertEquals(0, result.length);
    }

    @Test
    public void shouldSearchByProductNameWhenBookMatches() {
        Book book = new Book(1, "Гарри Поттер", 500, "Дж. Роулинг");

        when(repo.findAll()).thenReturn(new Product[]{book});

        Product[] result = manager.searchBy("Гарри");

        assertEquals(1, result.length);
        assertEquals(book, result[0]);
    }

    @Test
    public void shouldSearchByProductNameWhenSmartphoneMatches() {
        Smartphone phone = new Smartphone(1, "iPhone 15", 1000, "Apple");

        when(repo.findAll()).thenReturn(new Product[]{phone});

        Product[] result = manager.searchBy("iPhone");

        assertEquals(1, result.length);
        assertEquals(phone, result[0]);
    }
}
