package kz.example.consultation.service.impl;


import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import kz.example.consultation.DB.ConsultationDB;
import kz.example.consultation.model.Information;
import kz.example.consultation.model.Medicine;
import kz.example.consultation.service.ConsultationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.Arrays;
import java.util.List;

@Service
public class ConsultationServiceImpl implements ConsultationService {

    @Autowired
    private RestTemplate restTemplate;

    @Override
    @HystrixCommand(fallbackMethod = "getInfoById")
    public Information getInfoById(long id) {
        ConsultationDB consultationDB = new ConsultationDB();
        Information information = consultationDB.getInfoById(id);
        Medicine medicine = restTemplate.getForObject("http://medicines-service/medicines/" + id, Medicine.class);
        information.setMedicine(medicine);
        return information;
        }
    }



