package kz.example.consultation.service;


import kz.example.consultation.model.Information;
import kz.example.consultation.model.Medicine;

import java.util.List;

public interface ConsultationService {
    Information getInfoById(long id);
}
