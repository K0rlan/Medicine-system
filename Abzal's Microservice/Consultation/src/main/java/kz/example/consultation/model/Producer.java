package kz.example.consultation.model;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Service;

@Service
public class Producer {

    private static final String TOPIC = "consultation_requests";

    @Autowired
    private KafkaTemplate<String, ConsultationRequest> kafkaTemplate;

    public String bookRequestNotify(ConsultationRequest consultationRequest) {
        System.out.printf("#### -> Producing consultation request to notification service -> %s%n", consultationRequest);
        this.kafkaTemplate.send(TOPIC, consultationRequest);
        return "Successfully";
    }
}
