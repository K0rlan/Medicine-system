package kz.example.pharmacybranch.service.impl;

import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import kz.example.pharmacybranch.model.Information;
import kz.example.pharmacybranch.model.Pharmacy;
import kz.example.pharmacybranch.repository.PharmacyRepository;
import kz.example.pharmacybranch.service.ConsultationService;
import kz.example.pharmacybranch.service.PharmacyBranchCatalogService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.client.loadbalancer.LoadBalanced;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.Optional;

@Service
public class PharmacyBranchCatalogServiceImpl implements PharmacyBranchCatalogService {

    @Autowired
    private PharmacyRepository pharmacyRepository;

    @Autowired
    private ConsultationService consultationService;

    @Override
    @HystrixCommand(fallbackMethod = "getPharmacyById")
    public Pharmacy getPharmacyById(Long id) {
        Optional<Pharmacy> pharmacy = pharmacyRepository.findById(id);
        Information information = consultationService.getInfoById(id);
        pharmacy.get().setInformation(information.getDosage().toString());
        return pharmacy.get();
    }
}





