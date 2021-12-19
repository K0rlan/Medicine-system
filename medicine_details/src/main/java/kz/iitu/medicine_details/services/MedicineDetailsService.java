package kz.iitu.medicine_details.services;

import kz.iitu.medicine_details.model.MedicineDetails;

import java.util.Optional;

public interface MedicineDetailsService {

    Optional<MedicineDetails> getMedicineById(Long id);

    MedicineDetails getLocalMedicineById(Long id);
}
