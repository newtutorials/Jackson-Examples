package org.newtutorials.jackson.standard.model;

import java.util.List;

public class OrderBuilder {
    private Long id;
    private Customer customer;
    private List<OrderedProduct> orderedProducts;

    public OrderBuilder setId(Long id) {
        this.id = id;
        return this;
    }

    public OrderBuilder setCustomer(Customer customer) {
        this.customer = customer;
        return this;
    }

    public OrderBuilder setOrderedProducts(List<OrderedProduct> orderedProducts) {
        this.orderedProducts = orderedProducts;
        return this;
    }

    public Order createOrder() {
        return new Order(id, customer, orderedProducts);
    }
}