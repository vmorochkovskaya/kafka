package demo.kafka.consumer;

import java.util.concurrent.atomic.AtomicInteger;

import demo.kafka.event.PaymentSent;
import demo.kafka.service.PaymentService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.kafka.support.KafkaHeaders;
import org.springframework.messaging.handler.annotation.Header;
import org.springframework.messaging.handler.annotation.Payload;
import org.springframework.stereotype.Component;

@Slf4j
@RequiredArgsConstructor
@Component
public class PaymentConsumer {
    private final AtomicInteger counter = new AtomicInteger();
    private final PaymentService demoService;

    @KafkaListener(topics = "${kafkademo.outboundTopic}", groupId = "demo-consumer-group", containerFactory = "kafkaListenerContainerFactory")
    public void listen(@Header(KafkaHeaders.RECEIVED_KEY) String key, @Payload final PaymentSent command) {
        counter.getAndIncrement();
        log.info("Received message [" + counter.get() + "] key: " + key + ", message: " + command);
    }
}


