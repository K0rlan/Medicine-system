package kz.iitu.sales.service;

import kz.iitu.sales.model.SalesRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Service;

@Service
public class Producer {

    private static final String TOPIC = "sales";

    @Autowired
    private KafkaTemplate<String, SalesRequest> kafkaTemplate;

    public String salesNotify(SalesRequest salesRequest) {
        System.out.println(String.format("#### -> Producing book request to notification service -> %s", salesRequest));
        this.kafkaTemplate.send(TOPIC, salesRequest);
        return "Successfully";
    }
}
