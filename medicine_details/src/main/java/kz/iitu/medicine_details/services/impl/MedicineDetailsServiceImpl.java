package kz.iitu.medicine_details.services.impl;

import kz.iitu.medicine_details.model.Database;
import kz.iitu.medicine_details.model.MedicineDetails;
//import kz.iitu.medicine_details.repository.MedicineDetailsRepository;
import kz.iitu.medicine_details.repository.MedicineDetailsRepository;
import kz.iitu.medicine_details.services.MedicineDetailsService;
import kz.iitu.medicine_details.services.SalesService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;
@Service
public class MedicineDetailsServiceImpl implements MedicineDetailsService {

    @Autowired
    private SalesService salesService;

    @Autowired
    private MedicineDetailsRepository medicineDetailsRepository;

    @Override
    public Optional<MedicineDetails> getMedicineById(Long id) {
        Optional<MedicineDetails> medicineDetail = medicineDetailsRepository.findById(id);
        Double discount = salesService.getDiscountByMedicineCategory(medicineDetail.get().getCategory());
        medicineDetail.get().setSales(discount);
        return medicineDetail;
    }

    @Override
    public MedicineDetails getLocalMedicineById(Long id) {
        Database db = new Database();
        MedicineDetails medicineDetail = db.getMedicineById(id);
        Double discount = salesService.getDiscountByMedicineCategory(medicineDetail.getCategory());
        medicineDetail.setSales(discount);
        return medicineDetail;
    }
}
