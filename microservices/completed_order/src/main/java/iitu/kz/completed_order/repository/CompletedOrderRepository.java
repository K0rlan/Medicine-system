package iitu.kz.completed_order.repository;

import iitu.kz.completed_order.model.CompletedOrder;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CompletedOrderRepository extends JpaRepository<CompletedOrder, Long> {

}
