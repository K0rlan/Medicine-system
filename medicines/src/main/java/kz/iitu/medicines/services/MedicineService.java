package kz.iitu.medicines.services;

import kz.iitu.medicines.model.Medicine;

import java.util.List;

public interface MedicineService {

    List<Medicine> getAllMedicines();
    Medicine getMedicineById(Long id);
}
