package com.example.liorkaramany.opticsdatabase;

public class Customer {
    public String id;
    public String name;
    public int age;
    public int num;
    public double price;

    public Customer(String id, String name, int age, int num, double price) {
        this.id = id;
        this.name = name;
        this.age = age;
        this.num = num;
        this.price = price;
    }

    public Customer() {
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

    public int getNum() {
        return num;
    }

    public void setNum(int num) {
        this.num = num;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }
}
