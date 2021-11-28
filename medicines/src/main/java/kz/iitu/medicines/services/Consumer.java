package kz.iitu.medicines.services;

import kz.iitu.medicines.model.DiscountRequest;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Service;

import java.io.IOException;

@Service
public class Consumer {

    @KafkaListener(topics = "discount_requests", groupId = "group_id")
    public void consume(DiscountRequest discountRequest) throws IOException {
        System.out.println(String.format("#### -> Notify about discount: -> %s",
                "Medicine id: " + discountRequest.getMedicineId() + " discount: "
                        + discountRequest.getDiscount()));
    }
}
