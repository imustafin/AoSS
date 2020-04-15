/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package backend.direct;

import backend.interfaces.OrderProduct;
import backend.interfaces.Product;
import java.util.List;

/**
 *
 * @author ilgiz
 */
public class Order implements backend.interfaces.Order {
    final Integer id;
    final String firstName;
    final String lastName;
    final String phoneNumber;
    final String address;
    final Float totalCost;
    final Boolean isShipped;
    final String orderDate;
    final List<OrderProduct> products;
    
    public Order(Integer id, String firstName, String lastName, String phoneNumber,
            String address, Float totalCost, Boolean isShipped, String orderDate,
            List<OrderProduct> products) {
        this.id = id;
        this.firstName = firstName;
        this.lastName = lastName;
        this.phoneNumber = phoneNumber;
        this.address = address;
        this.totalCost = totalCost;
        this.isShipped = isShipped;
        this.orderDate = orderDate;
        this.products = products;
    }
    
    @Override
    public Integer getId() {
        return id;
    }

    @Override
    public String getFirstName() {
        return firstName;
    }

    @Override
    public String getLastName() {
        return lastName;
    }

    @Override
    public String getPhoneNumber() {
        return phoneNumber;
    }

    @Override
    public String getAddress() {
        return address;
    }

    @Override
    public Float getTotalCost() {
        return totalCost;
    }

    @Override
    public Boolean isShipped() {
        return isShipped;
    }

    @Override
    public String getOrderDate() {
        return orderDate;
    }

    @Override
    public List<OrderProduct> getProducts() {
        return products;
    }
}
