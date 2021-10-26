package kz.iitu.payment.service;

import kz.iitu.payment.model.Order;

public interface OrderService {
    Order getOrderById(Long id);
}
