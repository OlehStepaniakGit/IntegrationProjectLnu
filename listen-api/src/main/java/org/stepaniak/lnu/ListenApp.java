package org.stepaniak.lnu;

import lombok.SneakyThrows;
import org.stepaniak.lnu.mongo.MongoDataBaseService;
import org.stepaniak.lnu.mongo.entity.Data;
import org.stepaniak.lnu.rabbit.Listener;

import java.time.LocalDateTime;
import java.util.List;
import java.util.concurrent.TimeUnit;
import java.util.stream.Collectors;

public class ListenApp {
    private  static MongoDataBaseService service =  new MongoDataBaseService();

    @SneakyThrows
    public static void main(String[] args) {
        System.out.println("Extracting data from queue!");
        TimeUnit.SECONDS.sleep(5);

        Listener listener = new Listener();
        listener.listen();

        List<Data> messages =  listener.getRetrievedMessages()
                .stream()
                .map((element)-> new Data(element, LocalDateTime.now().toString()))
                .collect(Collectors.toList());

        service.writeMany(messages);
    }
}
