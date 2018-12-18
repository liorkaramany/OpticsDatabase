package com.example.liorkaramany.opticsdatabase;

/**
 * @author Lior Karamany
 * @version 1.0
 * @since 1.0
 */
public class Customer {

    public String customerID;
    public String fName;
    public String lName;
    public String address;
    public String city;
    public String phone;
    public String mobile;
    public String openDate;
    public int typeID;

    public Customer()
    {

    }

    public Customer(String customerID, String fName, String lName, String address, String city, String phone, String mobile) {
        this.customerID = customerID;
        this.fName = fName;
        this.lName = lName;
        this.address = address;
        this.city = city;
        this.phone = phone;
        this.mobile = mobile;
        //TODO: set openDate to current date.
        //this.openDate = openDate;
        this.typeID = 0;
    }

    public String getCustomerID() {
        return customerID;
    }

    public String getfName() {
        return fName;
    }

    public String getlName() {
        return lName;
    }

    public String getAddress() {
        return address;
    }

    public String getCity() {
        return city;
    }

    public String getPhone() {
        return phone;
    }

    public String getMobile() {
        return mobile;
    }

    public String getOpenDate() {
        return openDate;
    }

    public int getTypeID() {
        return typeID;
    }
}
