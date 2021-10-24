package kz.example.pharmacybranch.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class Pharmacy {
    private Long id;
    private String name;
    private String address;
    private Double rating;
    private  Specialist specialist;
    private Information information;

}
