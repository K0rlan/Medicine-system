package kz.example.consultation.service.impl;


import com.fasterxml.jackson.annotation.JsonIgnore;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import kz.example.consultation.model.Information;
import kz.example.consultation.model.Medicine;
import kz.example.consultation.repository.ConsultationRepository;
import kz.example.consultation.service.ConsultationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.client.loadbalancer.LoadBalanced;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.Arrays;
import java.util.List;
import java.util.Optional;

@Service
public class ConsultationServiceImpl implements ConsultationService {

    @Autowired
    @LoadBalanced
    private RestTemplate restTemplate;

    @Autowired
    private ConsultationService consultationService;

    @Autowired
    private ConsultationRepository consultationRepository;

    @Override
    @HystrixCommand(fallbackMethod = "getInfoById")
    public Information getInfoById(long id) {
        Optional<Information> information = consultationRepository.findById(id);
        if (information.isPresent()) {
            Medicine medicine = restTemplate.getForObject("http://medicines-service/medicines/" + id, Medicine.class);
            StringBuilder medicineString = new StringBuilder();
            medicineString.append(medicine.getName());

            information.get().setMedicine(medicineString.toString());
            return information.get();
        }
        return new Information();
    }
}



