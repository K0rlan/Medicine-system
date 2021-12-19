package kz.iitu.medicine_details.model;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "medicines_details")
public class MedicineDetails {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;
    private String dosage;
    private String manufacturer;
    private Category category;
    private Double price;
    private Double sales;
    private String description;
    private String formula;
    private String pharmacolGroup;
    private Double molarMass;
}
