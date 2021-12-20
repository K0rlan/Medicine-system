package iitu.kz.completed_order.service.impl;

import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixProperty;
import iitu.kz.completed_order.model.Payment;
import iitu.kz.completed_order.service.PaymentService;
import org.apache.commons.codec.binary.Base64;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Objects;

@Service
public class PaymentServiceImpl implements PaymentService {

    @Autowired
    private RestTemplate restTemplate;

    @Override
    @HystrixCommand(fallbackMethod = "getAllPaymentFallback",
            threadPoolKey = "getAllPayment",
            threadPoolProperties = {
                    @HystrixProperty(name = "coreSize", value = "100"),
                    @HystrixProperty(name = "maxQueueSize", value = "50"),
            })
    public List<Payment> getAllPayment() {
        return Arrays.asList(restTemplate.getForObject("http://payment-service/payments", Payment[].class));
//        String apiCredentials = "order-client:orderPassword";
//        String base64Credentials = new String(Base64.encodeBase64(apiCredentials.getBytes()));
//
//        HttpHeaders headers = new HttpHeaders();
//        headers.add("Authorization", "Basic " + base64Credentials);
//        HttpEntity<String> entity = new HttpEntity<>(headers);
//
//        List<Payment> payments = Arrays.asList(Objects.requireNonNull(restTemplate.exchange("http://payment-service/payments",
//                HttpMethod.GET, entity, Payment[].class).getBody()));
//        System.out.println("###" + payments);
//        return payments;
    }

    public List<Payment> getAllPaymentFallback() {
        List<Payment> paymentList = new ArrayList<>();
        Payment payment = new Payment();
        payment.setStatus("Fallback");

        return paymentList;
    }
}
