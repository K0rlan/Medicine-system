package kz.iitu.order.service;

import kz.iitu.order.model.Medicine;
import kz.iitu.order.model.Order;

public interface MedicineService {
    Medicine getMedicineById(Long id);
}
