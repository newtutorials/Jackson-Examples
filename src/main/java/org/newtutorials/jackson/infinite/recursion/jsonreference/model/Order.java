package org.newtutorials.jackson.infinite.recursion.jsonreference.model;

import com.fasterxml.jackson.annotation.JsonBackReference;

/**
 * Created by dani on 5/20/2017.
 */
public class Order {

    private Long id;

    @JsonBackReference
    private Customer customer;

    public Order() {
    }

    public Order(Long id, Customer customer) {
        this.id = id;
        this.customer = customer;
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

}