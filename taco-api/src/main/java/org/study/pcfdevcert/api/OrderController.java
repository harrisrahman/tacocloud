package org.study.pcfdevcert.api;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import org.study.pcfdevcert.domain.Order;
import org.study.pcfdevcert.repository.OrderRepository;

@RestController
@RequestMapping(path = "/orders",produces = "application/json")
@CrossOrigin(origins = "*")
public class OrderController {

    private OrderRepository orderRepository;

    @Autowired
    public OrderController(OrderRepository orderRepository){
        this.orderRepository = orderRepository;
    }

    @PostMapping(consumes = "application/json")
    @ResponseStatus(HttpStatus.CREATED)
    public Order saveOrder(@RequestBody Order order) {
        return orderRepository.save(order);
    }
}