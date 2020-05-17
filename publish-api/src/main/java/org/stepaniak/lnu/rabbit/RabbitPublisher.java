package org.stepaniak.lnu.rabbit;

import com.rabbitmq.client.Channel;
import com.rabbitmq.client.Connection;
import com.rabbitmq.client.ConnectionFactory;
import lombok.SneakyThrows;

public class RabbitPublisher {
    private static final String QUEUE = "pl";

    private ConnectionFactory factory = new ConnectionFactory();

    {
        factory.setHost("localhost");
    }

    public RabbitPublisher() {
    }

    @SneakyThrows
    public void publish(String message) {
        try (Connection connection = factory.newConnection();
             Channel channel = connection.createChannel()) {

            channel.queueDeclare(QUEUE, false, false, false, null);
            channel.basicPublish("", QUEUE, null, message.getBytes());

        }
    }
}
