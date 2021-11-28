package kz.iitu.order.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Service;

@Service
public class OrderProducer {

    private static final String TOPIC = "order_requests";

    @Autowired
    private KafkaTemplate<String, OrderRequest> kafkaTemplate;

    public String orderRequestNotify(OrderRequest orderRequest) {
        System.out.printf("#### -> Producing book request to notification service -> %s%n", orderRequest);
        this.kafkaTemplate.send(TOPIC, orderRequest);
        return "Successfully";
    }
}
