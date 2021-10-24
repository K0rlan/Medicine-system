package kz.iitu.sales.controller;

import io.swagger.annotations.Api;
import kz.iitu.sales.model.Category;
import kz.iitu.sales.service.SalesService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/medicines/discount")
@Api(value = "Sales Controller class", description = "The class allows to interact with medicine discounts.")
public class SalesController {
    @Autowired
    private SalesService salesService;

    @GetMapping("/{id}")
    public ResponseEntity<?> getMedicineDiscountById(@PathVariable Long id) {
        return ResponseEntity.ok(salesService.getDiscountByMediicineId(id));
    }
    @GetMapping("/category/{category}")
    public ResponseEntity<?> getMedicineDiscountByCategory(@PathVariable Category category) {
        return ResponseEntity.ok(salesService.getDiscountByMediicineCategory(category));
    }
}
