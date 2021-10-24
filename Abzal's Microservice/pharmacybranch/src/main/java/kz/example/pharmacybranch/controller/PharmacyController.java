package kz.example.pharmacybranch.controller;

import kz.example.pharmacybranch.service.PharmacyBranchCatalogService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/catalog")
public class PharmacyController {
    @Autowired
    private PharmacyBranchCatalogService pharmacyBranchCatalogService;


    @GetMapping("/pharmacies")
    public ResponseEntity<?> getAllPharmacy() {
        return ResponseEntity.ok(pharmacyBranchCatalogService.getAllPharmacies());
    }


}
