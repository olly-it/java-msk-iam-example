package it.olly.mskiam.consumer;

import java.util.function.Consumer;

import org.springframework.stereotype.Component;

@Component("KafkaConsumer")
public class KafkaConsumer implements Consumer<String> {

    @Override
    public void accept(String t) {
        System.out.println("KafkaConsumer.accept: " + t);
    }
}
