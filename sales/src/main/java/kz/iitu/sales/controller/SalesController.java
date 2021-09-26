package kz.iitu.sales.controller;

import kz.iitu.sales.service.SalesService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/medicines/discount")
public class SalesController {
    @Autowired
    private SalesService salesService;

    @GetMapping("/{id}")
    public ResponseEntity<?> getMedicineDiscountById(@PathVariable Long id) {
        return ResponseEntity.ok(salesService.getDiscountByMediicineId(id));
    }
}
