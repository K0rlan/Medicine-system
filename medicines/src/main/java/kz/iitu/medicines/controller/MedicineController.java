package kz.iitu.medicines.controller;

import io.swagger.annotations.Api;
import kz.iitu.medicines.model.Category;
import kz.iitu.medicines.services.MedicineService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/")
@Api(value = "Medicine Controller class", description = "The class allows to interact with Medicine base.")
public class MedicineController {
    @Autowired
    private MedicineService medicineService;

    @GetMapping
    public ResponseEntity<?> getAllMedicines() {
        return ResponseEntity.ok(medicineService.getAllMedicines());
    }

    @GetMapping("/{id}")
    public ResponseEntity<?> getMedicineById(@PathVariable Long id) {
        return ResponseEntity.ok(medicineService.getMedicineById(id));
    }

    @GetMapping("/category/{category}")
    public ResponseEntity<?> getMedicineByCategory(@PathVariable String category) {
        return ResponseEntity.ok(medicineService.getMedicineByCategory(category));
    }
}
