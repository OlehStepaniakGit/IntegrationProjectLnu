package org.stepaniak.lnu.rabbit;

import com.rabbitmq.client.Channel;
import com.rabbitmq.client.Connection;
import com.rabbitmq.client.ConnectionFactory;
import com.rabbitmq.client.DeliverCallback;
import lombok.SneakyThrows;

import java.util.ArrayList;
import java.util.List;

public class Listener {
    private final static String QUEUE = "pl";
    private List<String> retrievedMessages = new ArrayList<>();

    @SneakyThrows
    public void listen() {
        ConnectionFactory factory = new ConnectionFactory();
        factory.setHost("localhost");

        Connection connection = factory.newConnection();

        Channel channel = connection.createChannel();

        channel.queueDeclare(QUEUE, false, false, false, null);

        DeliverCallback deliverCallback = (consumerTag, delivery) -> {
            String message = new String(delivery.getBody(), "UTF-8");
            this.retrievedMessages.add(message);
            System.out.println("Extracted: " + message);
        };

        channel.basicConsume(QUEUE, true, deliverCallback, consumerTag -> {});

    }

    public List<String> getRetrievedMessages() {
        return retrievedMessages;
    }
}
