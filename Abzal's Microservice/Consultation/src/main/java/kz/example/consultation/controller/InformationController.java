package kz.example.consultation.controller;


import kz.example.consultation.service.ConsultationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/information")
public class InformationController {
    @Autowired
    private ConsultationService consultationService;



    @GetMapping("/{id}")
    public ResponseEntity<?> getInfoById(@PathVariable Long id) {
        return ResponseEntity.ok(consultationService.getInfoById(id));
    }
}
