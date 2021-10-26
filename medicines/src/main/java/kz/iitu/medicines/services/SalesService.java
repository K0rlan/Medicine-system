package kz.iitu.medicines.services;

import kz.iitu.medicines.model.Category;

public interface SalesService {
    Double getDiscountByMedicineCategory(Category category);
}
