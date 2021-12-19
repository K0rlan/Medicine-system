package kz.iitu.medicine_details.services;

import kz.iitu.medicine_details.model.Category;

public interface SalesService {
    Double getDiscountByMedicineCategory(Category category);
}
