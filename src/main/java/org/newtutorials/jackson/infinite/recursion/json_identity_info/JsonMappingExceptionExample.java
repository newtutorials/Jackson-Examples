package org.newtutorials.jackson.infinite.recursion.json_identity_info;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.newtutorials.jackson.infinite.recursion.json_identity_info.model.Customer;
import org.newtutorials.jackson.infinite.recursion.json_identity_info.model.Order;

import java.io.IOException;
import java.util.ArrayList;

/**
 * Created by dani on 5/21/2017.
 */
public class JsonMappingExceptionExample {
    public static void main(String[] args) {
        Customer customer = new Customer(1l,"The Cusotmer",new ArrayList<>());
        Order order1 = new Order(1l,customer);
        customer.getOrders().add(order1);
        Order order2 = new Order(2l,customer);
        customer.getOrders().add(order2);
        final ObjectMapper objectMapper = new ObjectMapper();
        try {
            String orderAsString =  objectMapper.writerWithDefaultPrettyPrinter().writeValueAsString(customer);
            System.out.println(orderAsString);
            Customer customerFromJson = objectMapper.readValue(orderAsString, Customer.class);
            System.out.println(customerFromJson);
        } catch (JsonProcessingException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
