package kz.iitu.order.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import javax.persistence.*;

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
