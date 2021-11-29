package kz.iitu.medicines.services;

import kz.iitu.medicines.model.Medicine;

import java.util.List;
import java.util.Optional;

public interface MedicineService {

    List<Medicine> getAllMedicines();

    Optional<Medicine> getMedicineById(Long id);

    List<Medicine> getMedicineByCategory(String category);
}
