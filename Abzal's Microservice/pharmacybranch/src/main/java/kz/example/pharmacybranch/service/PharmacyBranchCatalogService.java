package kz.example.pharmacybranch.service;

import kz.example.pharmacybranch.model.Pharmacy;
import kz.example.pharmacybranch.model.Specialist;

import java.util.List;

public interface PharmacyBranchCatalogService {
    Specialist getSpecialistById(Long id);
    Pharmacy getPharmacyById(Long id);
    List<Pharmacy> getAllPharmacies();
}
