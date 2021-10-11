package kz.example.pharmacybranch.service;

import kz.example.pharmacybranch.model.Pharmacy;

public interface PharmacyBranchCatalogService {
    Pharmacy getPharmacyById(Long id);
}
