package com.example.services.impl;

import com.example.model.Pharmacy;
import com.example.repository.PharmacyRepository;
import com.example.services.PharmacyBranchCatalogService;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixProperty;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

@Service
public class PharmacyBranchCatalogServiceImpl implements PharmacyBranchCatalogService {

    @Autowired
    private RestTemplate restTemplate;

    @Override
    @HystrixCommand(fallbackMethod = "getAllPharmacyFallback",
            threadPoolKey = "getAllPharmacy",
            threadPoolProperties = {
                    @HystrixProperty(name = "coreSize", value = "100"),
                    @HystrixProperty(name = "maxQueueSize", value = "50"),
            })
    public List<Pharmacy> getAllPharmacy() {
        return Arrays.asList(restTemplate.getForObject("http://payment-service/payments", Pharmacy[].class));
    }

    public List<Pharmacy> getAllPharmacyFallback() {
        List<Pharmacy> paymentList = new ArrayList<>();


        return paymentList;
    }
}





