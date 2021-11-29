package kz.iitu.sales.controller;

import io.swagger.annotations.Api;
import kz.iitu.sales.model.Category;
import kz.iitu.sales.model.DiscountRequest;
import kz.iitu.sales.service.Producer;
import kz.iitu.sales.service.SalesService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping
@Api(value = "Sales Controller class", description = "The class allows to interact with medicine discounts.")
public class SalesController {

    private final Producer producer;
    @Autowired
    private SalesService salesService;

    public SalesController(Producer producer) {
        this.producer = producer;
    }

    @GetMapping("/{id}")
    public ResponseEntity<?> getMedicineDiscountById(@PathVariable Long id) {
        return ResponseEntity.ok(salesService.getDiscountByMediicineId(id));
    }

    @GetMapping("/category/{category}")
    public ResponseEntity<?> getMedicineDiscountByCategory(@PathVariable Category category) {
        return ResponseEntity.ok(salesService.getDiscountByMediicineCategory(category));
    }

    @GetMapping("/producer")
    public String sendMessageToKafkaTopic2(@RequestParam("medicineId") Long medicineId) {
        Double discount = new Double(medicineId) * 10;
        DiscountRequest discountRequest = new DiscountRequest(new String(String.valueOf(medicineId)), discount);
        this.producer.discountRequestNotify(discountRequest);
        return "Your request sent successful!";
    }
}
