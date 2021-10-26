package kz.example.consultation.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Information {
    private Long id;
    private Medicine medicine;
    private Double dosage;
    private List<String> ills;
}
