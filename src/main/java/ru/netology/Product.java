package ru.netology;

public class Product {

    private int id;
    private String name;
    private int price;

    public Product(int id, String name, int price) {
        this.id = id;
        this.name = name;
        this.price = price;
    }

    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public int getPrice() {
        return price;
    }

    public void save(Product item) {
    }
    public void removeById(int id) {
    }

    public boolean matches(String search) {
        if (search == null || search.isEmpty()) {
            return false;
        }
        return getName().contains(search);
    }
}
