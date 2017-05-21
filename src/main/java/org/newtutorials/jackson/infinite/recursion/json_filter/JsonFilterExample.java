package org.newtutorials.jackson.infinite.recursion.json_filter;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.ObjectWriter;
import com.fasterxml.jackson.databind.ser.FilterProvider;
import com.fasterxml.jackson.databind.ser.impl.SimpleBeanPropertyFilter;
import com.fasterxml.jackson.databind.ser.impl.SimpleFilterProvider;
import org.newtutorials.jackson.infinite.recursion.json_filter.model.Customer;
import org.newtutorials.jackson.infinite.recursion.json_filter.model.Order;

import java.io.IOException;
import java.util.ArrayList;

/**
 * Created by dani on 5/21/2017.
 */
public class JsonFilterExample {
    public static void main(String[] args) {
        Customer customer = new Customer(1l,"The Cusotmer",new ArrayList<>());
        Order order1 = new Order(1l,customer);
        customer.getOrders().add(order1);
        Order order2 = new Order(2l,customer);
        customer.getOrders().add(order2);
        final ObjectMapper objectMapper = new ObjectMapper();
        objectMapper.setSerializationInclusion(JsonInclude.Include.NON_NULL);
        String[] ordrerIgnorableFieldNames = { "customer" };
        FilterProvider filters = new SimpleFilterProvider()
                .addFilter("filterOrder", SimpleBeanPropertyFilter.serializeAllExcept(ordrerIgnorableFieldNames));
        ObjectWriter writer = objectMapper.writer(filters);
        try {
            String orderAsString =  writer.writeValueAsString(customer);
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
