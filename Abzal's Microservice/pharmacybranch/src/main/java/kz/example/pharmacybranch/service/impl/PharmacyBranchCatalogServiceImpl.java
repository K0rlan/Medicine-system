package kz.example.pharmacybranch.service.impl;

import kz.example.pharmacybranch.model.Information;
import kz.example.pharmacybranch.model.Pharmacy;
import kz.example.pharmacybranch.model.Specialist;
import kz.example.pharmacybranch.service.PharmacyBranchCatalogService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Random;

@Service
public class PharmacyBranchCatalogServiceImpl implements PharmacyBranchCatalogService {

    @Autowired
    private RestTemplate restTemplate;



    @Override
    public Specialist getSpecialistById(Long id) {
        Specialist specialist = new Specialist();
        specialist.setId(id);
        specialist.setName("Name " + id);
        return specialist;
    }

    @Override
    public Pharmacy getPharmacyById(Long id) {
        Specialist specialist = new Specialist();
        specialist.setName("Abzal");
        specialist.setId(id);
        Random random = new Random();
        Pharmacy pharmacy = new Pharmacy();
        pharmacy.setId(id);
        pharmacy.setName("Name " + id);
        pharmacy.setSpecialist(specialist);
        pharmacy.setRating(10.0 * random.nextDouble());
        pharmacy.setAddress("Almaty");
        return pharmacy;
    }

    @Override
    public List<Pharmacy> getAllPharmacies() {
        List<Pharmacy> pharmacyList = new ArrayList<>();
        List<Long> pharmacyIds = new ArrayList<>(Arrays.asList(1L, 2L, 4L));
        for (Long id : pharmacyIds){
            Information information = restTemplate.getForObject("http://localhost:8086/information/" + id, Information.class);
            Random random = new Random();
            Specialist specialist = new Specialist();
            specialist.setName("Abzal");
            specialist.setId(id);
            Pharmacy pharmacy = new Pharmacy();
            pharmacy.setId(id);
            pharmacy.setName("Name " + id);
            pharmacy.setSpecialist(specialist);
            pharmacy.setRating(10.0 * random.nextDouble());
            pharmacy.setAddress("Almaty");
            pharmacy.setInformation(information);
        }
        return pharmacyList;
    }




}
