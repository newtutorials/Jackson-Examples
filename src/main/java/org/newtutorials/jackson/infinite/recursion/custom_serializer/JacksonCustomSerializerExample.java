package org.newtutorials.jackson.infinite.recursion.custom_serializer;

import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.SerializerProvider;
import com.fasterxml.jackson.databind.module.SimpleModule;
import com.fasterxml.jackson.databind.ser.std.StdSerializer;
import org.newtutorials.jackson.infinite.recursion.error.model.Customer;
import org.newtutorials.jackson.infinite.recursion.error.model.Order;

import java.io.IOException;
import java.util.ArrayList;

/**
 * Created by dani on 5/21/2017.
 */
public class JacksonCustomSerializerExample {
    public static void main(String[] args) {
        Customer customer = new Customer(1l,"The Cusotmer",new ArrayList<>());
        Order order1 = new Order(1l,customer);
        customer.getOrders().add(order1);
        Order order2 = new Order(2l,customer);
        customer.getOrders().add(order2);
        final ObjectMapper objectMapper = new ObjectMapper();
        SimpleModule module = new SimpleModule();
        module.addSerializer(Order.class, new StdSerializer<Order>(Order.class) {
            @Override
            public void serialize(Order value, JsonGenerator jsonGenerator, SerializerProvider provider) throws IOException {
                jsonGenerator.writeStartObject();
                jsonGenerator.writeNumberField("id", value.getId());
                jsonGenerator.writeEndObject();
            }
        });
        objectMapper.registerModule(module);
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
