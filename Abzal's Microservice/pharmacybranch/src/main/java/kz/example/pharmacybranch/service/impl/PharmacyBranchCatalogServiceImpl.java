package kz.example.pharmacybranch.service.impl;

import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import kz.example.pharmacybranch.DB.ConsultationDB;
import kz.example.pharmacybranch.model.Information;
import kz.example.pharmacybranch.model.Pharmacy;
import kz.example.pharmacybranch.service.PharmacyBranchCatalogService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

@Service
public class PharmacyBranchCatalogServiceImpl implements PharmacyBranchCatalogService {

    @Autowired
    private RestTemplate restTemplate;

    @Override
    @HystrixCommand(fallbackMethod = "getPharmacyById")
    public Pharmacy getPharmacyById(Long id) {
        ConsultationDB consultationDB = new ConsultationDB();
        Pharmacy pharmacy = consultationDB.getPharmacyById(id);
        Information information = restTemplate.getForObject("http://consultation-service/information/" + id, Information.class);
        pharmacy.setInformation(information);
        return pharmacy;
    }
}





