package org.newtutorials.jackson.infinite.recursion.json_filter.model;

import java.util.List;

/**
 * Created by dani on 5/20/2017.
 */
public class Customer {
    private Long id;
    private String name;

    private List<Order> orders;
    public Customer() {
    }

    public Customer(Long id, String name, List<Order> orders) {
        this.id = id;
        this.name = name;
        this.orders = orders;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public List<Order> getOrders() {
        return orders;
    }

    public void setOrders(List<Order> orders) {
        this.orders = orders;
    }
}
