package org.newtutorials.jackson.infinite.recursion.json_ignore_properties;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.newtutorials.jackson.infinite.recursion.json_ignore_properties.model.Customer;
import org.newtutorials.jackson.infinite.recursion.json_ignore_properties.model.Order;
import org.newtutorials.jackson.infinite.recursion.json_ignore_properties.model.User;

import java.io.IOException;
import java.util.ArrayList;

/**
 * Created by dani on 5/21/2017.
 */
public class JsonIgnorePropertiesExample {
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

            String user =  objectMapper.writerWithDefaultPrettyPrinter().writeValueAsString(new User("username","strongpassword"));
            System.out.println(user);
            String theUser = "{\n" +
                    "  \"name\" : \"username\",\n" +
                    "  \"isNotAbug\" : \"isAnImprovement\",\n" +
                    "  \"password\" : \"strongpassword\"\n" +
                    "}";
            User userFromJSON = objectMapper.readValue(theUser, User.class);
            System.out.println(userFromJSON);

        } catch (JsonProcessingException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
