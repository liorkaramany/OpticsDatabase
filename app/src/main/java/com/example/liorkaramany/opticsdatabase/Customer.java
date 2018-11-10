package com.example.liorkaramany.opticsdatabase;

public class Customer {
    public String id;
    public String name;
    public int age;
    public double left;
    public double right;
    public double price;

    public Customer() {
    }

    public Customer(String id, String name, int age, double left, double right, double price) {
        this.id = id;
        this.name = name;
        this.age = age;
        this.left = left;
        this.right = right;
        this.price = price;
    }

    public double getLeft() {
        return left;
    }

    public void setLeft(double left) {
        this.left = left;
    }

    public double getRight() {
        return right;
    }

    public void setRight(double right) {
        this.right = right;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }
}
