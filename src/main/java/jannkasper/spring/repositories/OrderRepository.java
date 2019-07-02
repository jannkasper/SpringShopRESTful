package jannkasper.spring.repositories;

import jannkasper.spring.domain.Order;
import jannkasper.spring.domain.Product;
import jannkasper.spring.domain.Status;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Date;
import java.util.List;
import java.util.UUID;

@Repository
public interface OrderRepository extends JpaRepository<Order, UUID> {
    List<Order> findAllByDate(Date date);
    List<Order> findAllByStatus (Status status);
    List<Order> findAllByUser_Login(String login);
    List<Order> findAllByProductsContains(Product product);
}
