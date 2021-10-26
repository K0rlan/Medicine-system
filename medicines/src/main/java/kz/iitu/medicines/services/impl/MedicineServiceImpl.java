package kz.iitu.medicines.services.impl;

import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import kz.iitu.medicines.db.Database;
import kz.iitu.medicines.model.Category;
import kz.iitu.medicines.model.Medicine;
import kz.iitu.medicines.services.MedicineService;
import kz.iitu.medicines.services.SalesService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

@Service
public class MedicineServiceImpl implements MedicineService {

    @Autowired
    private RestTemplate restTemplate;

    @Autowired
    private SalesService salesService;

    @Override
    public List<Medicine> getAllMedicines() {
        Database db = new Database();
        List<Medicine> medicineList = db.getFullMedicineList();
        for (Medicine med : medicineList) {
            Double discount = salesService.getDiscountByMedicineCategory(med.getCategory());
            med.setSales(discount);
        }
        return medicineList;
    }

    @Override
    public Medicine getMedicineById(Long id) {
        Database db = new Database();
        Medicine medicine = db.getMedicineById(id);
        Double discount = salesService.getDiscountByMedicineCategory(medicine.getCategory());
        medicine.setSales(discount);
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
