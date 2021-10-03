package kz.iitu.medicines.services.impl;

import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
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
        List<Medicine> medicineList = new ArrayList<>();

        List<Long> medicineIds = new ArrayList<>(Arrays.asList(1L, 2L, 4L));
        for (Long id : medicineIds) {
            Medicine medicine = new Medicine();
            medicine.setId(id);
            medicine.setName("Title " + id);
            Category category = Category.VITAMINS;
            medicine.setCategory(category);
            medicine.setDosage("Dosage " + id);
            medicine.setManufacturer("Manufacturer " + id);
            medicine.setPrice(1000.0);
            Double discount = restTemplate.getForObject("http://discount-service/medicines/discount/category/" + category, Double.class);
            medicine.setSales(discount);
            medicineList.add(medicine);
        }

        return medicineList;
    }

    @Override
    @HystrixCommand(fallbackMethod = "getMedicineById")
    public Medicine getMedicineById(Long id) {
        System.out.println("id = " + id);
        Medicine medicine = new Medicine();
        medicine.setId(id);
        medicine.setName("Title " + id);
        Category category = Category.VITAMINS;
        medicine.setCategory(category);
        medicine.setDosage("Dosage " + id);
        medicine.setManufacturer("Manufacturer " + id);
        medicine.setPrice(1000.0);
        Double discount = restTemplate.getForObject("http://discount-service/medicines/discount/category/" + category, Double.class);
        medicine.setSales(discount);
        return medicine;
    }
}
