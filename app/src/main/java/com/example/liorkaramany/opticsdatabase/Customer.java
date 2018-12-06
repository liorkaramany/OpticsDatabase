package com.example.liorkaramany.opticsdatabase;

/**
 * @author Lior Karamany
 * @version 1.0
 * @since 1.0
 */
public class Customer {
    /**
     * The ID of the customer (used for storing inside database).
     */
    public String id;
    /**
     * The name of the customer.
     */
    public String name;
    /**
     * The age of the customer.
     */
    public int age;
    /**
     * The number in the left eye of the customer.
     */
    public double left;
    /**
     * The number in the right eye of the customer.
     */
    public double right;
    /**
     * The price that the customer's glasses cost.
     */
    public double price;
    /**
     * The URL used for storing the image of the document of the customer.
     */
    public String url;


    /**
     * Create a Customer object.
     * <p>
     * Create an empty Customer object.
     * </p>
     *
     * @return A reference to the new Customer object.
     */
    public Customer() {
    }

    /**
     * Create a Customer object.
     * <p>
     * Create a Customer object with a given id, name, age, numbers of his eyes, the price of his glasses and a URL to an image that contains the image of his document.
     * </p>
     *
     * @param  id The ID of the object (used for storing inside database).
     * @param  name The name of the customer.
     * @param  age The age of the customer.
     * @param  left The number of the customer's left eye.
     * @param  right The number of the customer's right eye.
     * @param  price The price of
     * @param  url Description text text text.
     * @return A reference to the new Customer object.
     */
    public Customer(String id, String name, int age, double left, double right, double price, String url) {
        this.id = id;
        this.name = name;
        this.age = age;
        this.left = left;
        this.right = right;
        this.price = price;

        this.url = url;
    }

    /**
     * Get the number in the left eye of the customer.
     *
     * @return The number in the left eye of the customer.
     */
    public double getLeft() {
        return left;
    }

    /**
     * Set the number in the left eye of the customer.
     *
     * @param left The number in the left eye of the customer.
     */
    public void setLeft(double left) {
        this.left = left;
    }

    /**
     * Get the number in the right eye of the customer.
     *
     * @return The number in the right eye of the customer.
     */
    public double getRight() {
        return right;
    }

    /**
     * Set the number in the right eye of the customer.
     *
     * @param right The number in the left eye of the customer.
     */
    public void setRight(double right) {
        this.right = right;
    }

    /**
     * Get the ID the customer.
     *
     * @return The ID of the customer.
     */
    public String getId() {
        return id;
    }

    /**
     * Set the ID of the customer.
     *
     * @param id The ID of the customer.
     */
    public void setId(String id) {
        this.id = id;
    }

    /**
     * Get the name the customer.
     *
     * @return The name of the customer.
     */
    public String getName() {
        return name;
    }

    /**
     * Set the name of the customer.
     *
     * @param name The name of the customer.
     */
    public void setName(String name) {
        this.name = name;
    }

    /**
     * Get the age the customer.
     *
     * @return The age of the customer.
     */
    public int getAge() {
        return age;
    }

    /**
     * Set the age of the customer.
     *
     * @param age The age of the customer.
     */
    public void setAge(int age) {
        this.age = age;
    }

    /**
     * Get the price the customer.
     *
     * @return The price of the customer.
     */
    public double getPrice() {
        return price;
    }

    /**
     * Set the price of the customer.
     *
     * @param price The price of the customer.
     */
    public void setPrice(double price) {
        this.price = price;
    }

    /**
     * Get the URL the customer's document.
     *
     * @return The URL the customer's document.
     */
    public String getUrl() {
        return url;
    }

    /**
     * Set the URL of the customer.
     *
     * @param url The URL of the customer.
     */
    public void setUrl(String url) {
        this.url = url;
    }
}
