package org.newtutorials.jackson.standard.model;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by dani on 5/20/2017.
 */
public class Order {

    private Long id;
    private Customer customer;
    List<OrderedProduct> orderedProducts = new ArrayList<>();

    public Order() {
    }

    public Order(Long id, Customer customer, List<OrderedProduct> orderedProducts) {
        this.id = id;
        this.customer = customer;
        this.orderedProducts = orderedProducts;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Customer getCustomer() {
        return customer;
    }

    public void setCustomer(Customer customer) {
        this.customer = customer;
    }

    public List<OrderedProduct> getOrderedProducts() {
        return orderedProducts;
    }

    public void setOrderedProducts(List<OrderedProduct> orderedProducts) {
        this.orderedProducts = orderedProducts;
    }

    @Override
    public String toString() {
        return "Order{" +
                "id=" + id +
                ", customer=" + customer +
                ", orderedProducts=" + orderedProducts +
                '}';
    }
}
