package kz.iitu.medicine_details.controller;

import io.swagger.annotations.Api;
import kz.iitu.medicine_details.model.MedicineDetails;

import kz.iitu.medicine_details.services.MedicineDetailsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/")
@Api(value = "Medicine Details Controller class", description = "The class allows to interact with Medicine base.")
public class MedicineDetailsController {

    @Autowired
    private MedicineDetailsService medicineDetailsService;

    @GetMapping("/{id}")
    public ResponseEntity<?> getMedicineById(@PathVariable Long id) {
        return ResponseEntity.ok(medicineDetailsService.getMedicineById(id));
    }

    @GetMapping("local/{id}")
    public ResponseEntity<?> getLocalMedicineById(@PathVariable Long id) {
        return ResponseEntity.ok(medicineDetailsService.getLocalMedicineById(id));
    }
}
