package iitu.kz.completed_order.controller;

import iitu.kz.completed_order.service.CompletedOrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/")
public class Controller {
    @Autowired
    private CompletedOrderService completedOrderService;

    @GetMapping("")
    public ResponseEntity<?> getAllCompletedOrder() {
        return ResponseEntity.ok(completedOrderService.getAllCompletedOrder());
    }
}
