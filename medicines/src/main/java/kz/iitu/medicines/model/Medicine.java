package kz.iitu.medicines.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.ArrayList;
import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class Medicine {
    private Long id;
    private String name;
    private String dosage;
    private String manufacturer;
    private Category category;
    private Double price;
    private Double sales;
}
