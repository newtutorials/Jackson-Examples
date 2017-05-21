package org.newtutorials.jackson.standard.model;

public class CustomerBuilder {
    private Long id;
    private String name;

    public CustomerBuilder setId(Long id) {
        this.id = id;
        return this;
    }

    public CustomerBuilder setName(String name) {
        this.name = name;
        return this;
    }

    public Customer createCustomer() {
        return new Customer(id, name);
    }
}