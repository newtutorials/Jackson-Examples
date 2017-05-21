package org.newtutorials.jackson.standard.model;

public class OrderedProductBuilder {
    private Long id;
    private Product product;
    private int quantity;

    public OrderedProductBuilder setId(Long id) {
        this.id = id;
        return this;
    }

    public OrderedProductBuilder setProduct(Product product) {
        this.product = product;
        return this;
    }

    public OrderedProductBuilder setQuantity(int quantity) {
        this.quantity = quantity;
        return this;
    }

    public OrderedProduct createOrderedProduct() {
        return new OrderedProduct(id, product, quantity);
    }
}