package kz.iitu.sales.service;

import kz.iitu.sales.model.Category;

public interface SalesService {
    Double getDiscountByMediicineId(Long id);

    Double getDiscountByMediicineCategory(Category category);
}
