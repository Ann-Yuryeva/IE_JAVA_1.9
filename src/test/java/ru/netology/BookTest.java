package ru.netology;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class BookTest {

    @Test
    public void shouldMatchBookByName() {
        Book book = new Book(1, "Гарри Поттер", 500, "Дж. Роулинг");
        assertTrue(book.matches("Гарри"));
    }

    @Test
    public void shouldMatchBookByAuthor() {
        Book book = new Book(1, "Гарри Поттер", 500, "Дж. Роулинг");
        assertTrue(book.matches("Роулинг"));
    }

    @Test
    public void shouldNotMatchBookWhenSearchNotFound() {
        Book book = new Book(1, "Гарри Поттер", 500, "Дж. Роулинг");
        assertFalse(book.matches("Толстой"));
    }

    @Test
    public void shouldNotMatchBookWhenSearchIsNull() {
        Book book = new Book(1, "Гарри Поттер", 500, "Дж. Роулинг");
        assertFalse(book.matches(null));
    }

    @Test
    public void shouldNotMatchBookWhenSearchIsEmpty() {
        Book book = new Book(1, "Гарри Поттер", 500, "Дж. Роулинг");
        assertFalse(book.matches(""));
    }

    @Test
    public void shouldMatchBookByFullName() {
        Book book = new Book(1, "Гарри Поттер", 500, "Дж. Роулинг");
        assertTrue(book.matches("Гарри Поттер"));
    }
}