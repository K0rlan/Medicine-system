package kz.iitu.medicine_details.repository;

import kz.iitu.medicine_details.model.MedicineDetails;
import org.springframework.data.jpa.repository.JpaRepository;

public interface MedicineDetailsRepository extends JpaRepository<MedicineDetails, Long> {

}
