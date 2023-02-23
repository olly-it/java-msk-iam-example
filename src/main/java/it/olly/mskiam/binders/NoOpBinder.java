package it.olly.mskiam.binders;

import org.springframework.boot.autoconfigure.condition.ConditionalOnProperty;
import org.springframework.cloud.stream.binder.Binder;
import org.springframework.cloud.stream.binder.Binding;
import org.springframework.cloud.stream.binder.ConsumerProperties;
import org.springframework.cloud.stream.binder.ProducerProperties;
import org.springframework.messaging.MessageChannel;
import org.springframework.stereotype.Component;

@Component
@ConditionalOnProperty(name = "spring.cloud.stream.binders-disabled", havingValue = "true")
public class NoOpBinder implements Binder<MessageChannel, ConsumerProperties, ProducerProperties> {

    @Override
    public Binding<MessageChannel> bindConsumer(String name, String group, MessageChannel inboundBindTarget,
            ConsumerProperties consumerProperties) {
        return null;
    }

    @Override
    public Binding<MessageChannel> bindProducer(String name, MessageChannel outboundBindTarget,
            ProducerProperties producerProperties) {
        return null;
    }

}
