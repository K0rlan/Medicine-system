package kz.iitu.payment.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class Medicine {
    private Long id;
    private String name;
    private String dosage;
    private String manufacturer;
    private String category;
    private Double price;
}
