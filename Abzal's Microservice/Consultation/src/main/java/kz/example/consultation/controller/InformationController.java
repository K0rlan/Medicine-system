package kz.example.consultation.controller;


import kz.example.consultation.model.ConsultationRequest;
import kz.example.consultation.model.Information;
import kz.example.consultation.model.Producer;
import kz.example.consultation.service.ConsultationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/information")
public class InformationController {

    private final Producer producer;
    private ConsultationService consultationService;

    @Autowired
    public InformationController(Producer producer, ConsultationService consultationService) {
        this.producer = producer;
        this.consultationService = consultationService;
    }

    @GetMapping("/{id}")
    public ResponseEntity<?> getInfoById(@PathVariable Long id) {
        return ResponseEntity.ok(consultationService.getInfoById(id));
    }

    @GetMapping("/producer")
    public String sendMessageToKafkaTopic2(@RequestParam("id") Long id) {

        ConsultationRequest consultationRequest = new ConsultationRequest(id.toString(), consultationService.getInfoById(id));
        this.producer.bookRequestNotify(consultationRequest);
        return "Your request sent successful!";
    }
}
