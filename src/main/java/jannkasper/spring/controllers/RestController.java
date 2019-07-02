package jannkasper.spring.controllers;

import jannkasper.spring.domain.Order;
import jannkasper.spring.repositories.OrderRepository;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseStatus;

import java.util.List;
import java.util.stream.Collectors;

@org.springframework.web.bind.annotation.RestController
public class RestController {

    private final OrderRepository orderRepository;

    public RestController(OrderRepository orderRepository) {
        this.orderRepository = orderRepository;
    }


    @GetMapping({"/list"})
    @ResponseStatus(HttpStatus.OK)
    public List<Order> getListOfUsers() {
        return orderRepository.findAll()
                .stream()
                .map(order -> {
                    order.setProducts(null);
                    order.setUser(null);
                    return order;
                })
                .collect(Collectors.toList());
    }
}
