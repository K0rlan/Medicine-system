package kz.iitu.medicines.services.impl;

import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import kz.iitu.medicines.db.Database;
import kz.iitu.medicines.model.Category;
import kz.iitu.medicines.model.Medicine;
import kz.iitu.medicines.services.MedicineService;
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

    @Override
    @HystrixCommand(fallbackMethod = "getAllMedicines")
    public List<Medicine> getAllMedicines() {
        Database db = new Database();
        List<Medicine> medicineList = db.getFullMedicineList();
        for (Medicine med : medicineList) {
            Double discount = restTemplate.getForObject("http://discount-service/medicines/discount/category/" + med.getCategory(), Double.class);
            med.setSales(discount);
        }
        return medicineList;
    }

    @Override
    @HystrixCommand(fallbackMethod = "getMedicineById")
    public Medicine getMedicineById(Long id) {
        Database db = new Database();
        Medicine medicine = db.getMedicineById(id);
        Double discount = restTemplate.getForObject("http://discount-service/medicines/discount/category/" + medicine.getCategory(), Double.class);
        medicine.setSales(discount);
        return medicine;
    }

    @Override
    @HystrixCommand(fallbackMethod = "getMedicineByCategory")
    public List<Medicine> getMedicineByCategory(String category) {
        Database db = new Database();
        List<Medicine> medicineList = db.getMedicineByCategory(Category.valueOf(category));
        for (Medicine med : medicineList) {
            Double discount = restTemplate.getForObject("http://discount-service/medicines/discount/category/" + med.getCategory(), Double.class);
            med.setSales(discount);
        }
        return medicineList;
    }
}
