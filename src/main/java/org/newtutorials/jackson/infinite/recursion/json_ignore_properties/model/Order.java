package org.newtutorials.jackson.infinite.recursion.json_ignore_properties.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

/**
 * Created by dani on 5/20/2017.
 */
@JsonIgnoreProperties({"customer"})
//@JsonIgnoreProperties(ignoreUnknown = true, value={"customer"})
public class Order {

    private Long id;

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
