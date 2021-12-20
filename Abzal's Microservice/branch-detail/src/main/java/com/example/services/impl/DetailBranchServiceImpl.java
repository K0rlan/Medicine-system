package com.example.services.impl;

import com.example.model.DetailBranch;
import com.example.model.Pharmacy;
import com.example.repository.DetailBranchRepository;
import com.example.services.DetailBranchService;
import com.example.services.PharmacyBranchCatalogService;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixProperty;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.ArrayList;
import java.util.List;

public class DetailBranchServiceImpl implements DetailBranchService {

    @Autowired
    private PharmacyBranchCatalogService pharmacyBranchCatalogService;

    @Autowired
    private DetailBranchRepository detailBranchRepository;

    @Override
    @HystrixCommand(fallbackMethod = "getAllBranchDetailFallback",
            threadPoolKey = "getAllBranchDetail",
            threadPoolProperties = {
                    @HystrixProperty(name = "coreSize", value = "100"),
                    @HystrixProperty(name = "maxQueueSize", value = "50"),
            })
    public List<DetailBranch> getAllDetailBranch() {
        List<Pharmacy> pharmacies = pharmacyBranchCatalogService.getAllPharmacy();
        List<DetailBranch> detailBranches = detailBranchRepository.findAll();
        for (Pharmacy pharmacy : pharmacies) {
            if (pharmacy.getAddress().equals("Almaty, Manas 5")) {
                DetailBranch detailBranch = new DetailBranch();
                detailBranch.setAddress(pharmacy.getAddress());
                detailBranch.setId(pharmacy.getId());
                detailBranches.add(detailBranch);
            }
        }
        return detailBranches;
    }

    public List<DetailBranch> getAllDetailBranchFallback() {
        List<DetailBranch> detailBranches = new ArrayList<>();
        DetailBranch detailBranch = new DetailBranch(1L, "Almaty, Manas 5", 1L);
        detailBranches.add(detailBranch);
        return detailBranches;
    }
}
