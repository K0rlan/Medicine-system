package kz.example.pharmacybranch.model;

import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Service;

import java.io.IOException;

@Service
public class Consumer {


    @KafkaListener(topics = "consultation_requests", groupId = "group_id")
    public void consume(ConsultationRequest consultationRequest) throws IOException {
        System.out.printf("#### -> Notify user by email: -> %s%n",
                "User " + consultationRequest.getUserId()+ " purchased information "
                        + consultationRequest);
    }
}
