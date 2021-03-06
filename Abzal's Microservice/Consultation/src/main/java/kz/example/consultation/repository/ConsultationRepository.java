package kz.example.consultation.repository;

import kz.example.consultation.model.Information;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ConsultationRepository extends JpaRepository<Information, Long> {
    Information findInformationById(Long id);
}
