package kz.iitu.sales.service;

import kz.iitu.sales.model.DiscountRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Service;

@Service
public class Producer {

    private static final String TOPIC = "discount_requests";

    @Autowired
    private KafkaTemplate<String, DiscountRequest> kafkaTemplate;

    public String discountRequestNotify(DiscountRequest discountRequest) {
        System.out.println(discountRequest.getMedicineId());
        System.out.println(discountRequest.getDiscount());
        System.out.println(String.format("#### -> Producing discount request to notification service -> %s", discountRequest.getMedicineId(), discountRequest.getDiscount()));
        this.kafkaTemplate.send(TOPIC, discountRequest);
        return "Successfully";
    }
}
