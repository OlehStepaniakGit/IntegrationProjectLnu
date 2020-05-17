package org.stepaniak.lnu;

import lombok.SneakyThrows;
import org.stepaniak.lnu.rabbit.RabbitPublisher;
import org.stepaniak.lnu.web.driver.WebDriverService;

import java.util.List;
import java.util.concurrent.TimeUnit;

public class PublishApp {
    private final static RabbitPublisher publisher = new RabbitPublisher();
    private final static WebDriverService service = new WebDriverService();

    @SneakyThrows
    public static void main(String[] args) {
        while (true){
            List<String> messages = service.load();

            messages.forEach((message)->{
                System.out.println(message);
                publisher.publish(message);
            });

            System.out.println("Success!");

            TimeUnit.SECONDS.sleep(30);
        }
    }
}
