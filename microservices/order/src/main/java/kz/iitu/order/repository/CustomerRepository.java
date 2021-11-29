package kz.iitu.order.repository;

import kz.iitu.order.model.Customer;
import kz.iitu.order.model.Order;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CustomerRepository extends JpaRepository<Customer, Long> {
    Customer findCustomerById(Long id);
}
