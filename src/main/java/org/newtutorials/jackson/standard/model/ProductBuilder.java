package org.newtutorials.jackson.standard.model;

public class ProductBuilder {
    private Long id;
    private String name;
    private Double price;

    public ProductBuilder setId(Long id) {
        this.id = id;
        return this;
    }

    public ProductBuilder setName(String name) {
        this.name = name;
        return this;
    }

    public ProductBuilder setPrice(Double price) {
        this.price = price;
        return this;
    }

    public Product createProduct() {
        return new Product(id, name, price);
    }
}