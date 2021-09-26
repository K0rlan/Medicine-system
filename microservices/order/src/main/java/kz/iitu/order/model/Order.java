package kz.iitu.order.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class Order {
    private Long id;
    private List<Medicine> medicines;
    private Customer customer;
    private Double totalCost;
}
