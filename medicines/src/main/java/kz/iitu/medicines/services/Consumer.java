package kz.iitu.medicines.services;

import kz.iitu.medicines.model.SalesRequest;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Service;

import java.io.IOException;

@Service
public class Consumer {
    @KafkaListener(topics = "sales", groupId = "group_id")
    public void consume(SalesRequest salesRequest) throws IOException {
        System.out.println(String.format("#### -> Notify user by email: -> %s",
                "Sales: " + salesRequest.getUserId() + salesRequest.getSales()));
    }
}