package kz.iitu.payment.model;

import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Service;

import java.io.IOException;

@Service
public class Consumer {
    @KafkaListener(topics = "order_requests", groupId = "group_id")
    public void consume(OrderRequest orderRequest) throws IOException {
        System.out.printf("#### -> Notify user by email: -> %s%n",
                "User " + orderRequest.getId() + " purchased order " + orderRequest);
    }
}
