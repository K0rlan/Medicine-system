package kz.iitu.payment.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class Delivery {
    private Long id;
    private Courier courier;
    private Payment payment;
    private String status;
}
