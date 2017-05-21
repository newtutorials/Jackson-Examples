package org.newtutorials.jackson.standard;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.newtutorials.jackson.standard.model.*;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by dani on 5/20/2017.
 */

public class JacksonSimpleExample {
    public static void main(String[] args) {
        final ObjectMapper objectMapper = new ObjectMapper();
        Order order = createOrder();
        try {
            String orderAsString =  objectMapper.writerWithDefaultPrettyPrinter().writeValueAsString(order);
            System.out.println(orderAsString);
            Order orderFromJson = objectMapper.readValue(orderAsString, Order.class);
            System.out.println(orderFromJson);
        } catch (JsonProcessingException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private static Order createOrder() {
        Customer customer = new CustomerBuilder()
                .setId(1l)
                .setName("First Customer")
                .createCustomer();
        Product product = new ProductBuilder()
                .setId(1l)
                .setName("Product One")
                .setPrice(1.5d)
                .createProduct();
        Product productTwo = new ProductBuilder()
                .setId(1l)
                .setName("Product Two")
                .setPrice(5d)
                .createProduct();
        List<OrderedProduct> orderedProducts = new ArrayList<>();
        orderedProducts.add(
                new OrderedProductBuilder()
                        .setId(1l)
                        .setProduct(product)
                        .setQuantity(1)
                        .createOrderedProduct());
        orderedProducts.add(
                new OrderedProductBuilder()
                        .setId(2l)
                        .setProduct(productTwo)
                        .setQuantity(5)
                        .createOrderedProduct());
        return new OrderBuilder()
                .setId(1l)
                .setCustomer(customer)
                .setOrderedProducts(orderedProducts)
                .createOrder();
    }
}
