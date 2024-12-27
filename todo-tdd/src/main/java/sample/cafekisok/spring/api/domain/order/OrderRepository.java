package sample.cafekisok.spring.api.domain.order;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import sample.cafekisok.spring.domain.order.Order;

@Repository
public interface OrderRepository extends JpaRepository<Order, Long> {

}
