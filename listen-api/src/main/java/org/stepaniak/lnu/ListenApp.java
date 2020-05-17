package org.stepaniak.lnu;

import lombok.SneakyThrows;
import org.stepaniak.lnu.rabbit.Listener;

import java.util.concurrent.TimeUnit;

public class ListenApp {

    @SneakyThrows
    public static void main(String[] args) {
        System.out.println("Extracting data from queue!");
        TimeUnit.SECONDS.sleep(5);

        Listener listener = new Listener();
        listener.listen();

    }
}
