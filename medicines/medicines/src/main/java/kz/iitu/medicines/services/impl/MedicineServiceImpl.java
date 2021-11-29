package kz.iitu.medicines.services.impl;

import kz.iitu.medicines.db.Database;
import kz.iitu.medicines.model.Category;
import kz.iitu.medicines.model.Medicine;
import kz.iitu.medicines.repository.MedicineRepository;
import kz.iitu.medicines.services.MedicineService;
import kz.iitu.medicines.services.SalesService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.List;
import java.util.Optional;

@Service
public class MedicineServiceImpl implements MedicineService {

    @Autowired
    private RestTemplate restTemplate;

    @Autowired
    private SalesService salesService;

    @Autowired
    private MedicineRepository medicineRepository;

    @Override
    public List<Medicine> getAllMedicines() {
//        Database db = new Database();
        List<Medicine> medicineList = medicineRepository.findAll();
        for (Medicine med : medicineList) {
            Double discount = salesService.getDiscountByMedicineCategory(med.getCategory());
            med.setSales(discount);
        }
        return medicineList;
    }

    @Override
    public Optional<Medicine> getMedicineById(Long id) {
//        Database db = new Database();
//        Medicine medicine = db.getMedicineById(id);
        Optional<Medicine> medicine = medicineRepository.findById(id);
        Double discount = salesService.getDiscountByMedicineCategory(medicine.get().getCategory());
        medicine.get().setSales(discount);
        return medicine;
    }

    @Override
    public List<Medicine> getMedicineByCategory(String category) {
        Database db = new Database();
        List<Medicine> medicineList = db.getMedicineByCategory(Category.valueOf(category));
        for (Medicine med : medicineList) {
            Double discount = salesService.getDiscountByMedicineCategory(med.getCategory());
            med.setSales(discount);
        }
        return medicineList;
    }
}
