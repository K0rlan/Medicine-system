package kz.example.consultation.service.impl;


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
    public Information getInfoById(long id) {
        Information information = new Information();
        Medicine medicine = restTemplate.getForObject("http://localhost:8081/medicines/" + id, Medicine.class);
        information.setId(id);
        information.setDosage(10.0);
        List<String> illsNames = Arrays.asList("sup1", "sup2", "sup3");
        information.setIlls(illsNames);
        information.setMedicine(medicine);
        return information;
        }
    }



