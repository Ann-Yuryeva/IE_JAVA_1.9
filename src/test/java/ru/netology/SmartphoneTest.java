package ru.netology;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class SmartphoneTest {

    @Test
    public void shouldMatchSmartphoneByName() {
        Smartphone phone = new Smartphone(2, "iPhone 15", 1000, "Apple");
        assertTrue(phone.matches("iPhone"));
    }

    @Test
    public void shouldMatchSmartphoneByManufacturer() {
        Smartphone phone = new Smartphone(2, "iPhone 15", 1000, "Apple");
        assertTrue(phone.matches("Apple"));
    }

    @Test
    public void shouldNotMatchSmartphoneWhenSearchNotFound() {
        Smartphone phone = new Smartphone(2, "iPhone 15", 1000, "Apple");
        assertFalse(phone.matches("Samsung"));
    }

    @Test
    public void shouldNotMatchSmartphoneWhenSearchIsNull() {
        Smartphone phone = new Smartphone(2, "iPhone 15", 1000, "Apple");
        assertFalse(phone.matches(null));
    }

    @Test
    public void shouldNotMatchSmartphoneWhenSearchIsEmpty() {
        Smartphone phone = new Smartphone(2, "iPhone 15", 1000, "Apple");
        assertFalse(phone.matches(""));
    }

    @Test
    public void shouldMatchSmartphoneByFullName() {
        Smartphone phone = new Smartphone(2, "iPhone 15", 1000, "Apple");
        assertTrue(phone.matches("iPhone 15"));
    }
}