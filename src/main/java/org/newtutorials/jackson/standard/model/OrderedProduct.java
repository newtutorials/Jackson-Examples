package org.newtutorials.jackson.standard.model;

/**
 * Created by dani on 5/20/2017.
 */
public class OrderedProduct {
    private Long id;
    private Product product;
    private int quantity;

    public OrderedProduct() {
    }

    public OrderedProduct(Long id, Product product, int quantity) {
        this.id = id;
        this.product = product;
        this.quantity = quantity;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }



    public Product getProduct() {
        return product;
    }

    public void setProduct(Product product) {
        this.product = product;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }
}
