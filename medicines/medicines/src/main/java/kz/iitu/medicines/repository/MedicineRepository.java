package kz.iitu.medicines.repository;

import kz.iitu.medicines.model.Medicine;
import org.springframework.data.jpa.repository.JpaRepository;

public interface MedicineRepository extends JpaRepository<Medicine, Long> {
}
