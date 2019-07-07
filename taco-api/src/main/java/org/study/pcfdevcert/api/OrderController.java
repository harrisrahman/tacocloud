package org.study.pcfdevcert.api;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.study.pcfdevcert.domain.Order;
import org.study.pcfdevcert.kafka.OrderMessageProducerServiceImpl;
import org.study.pcfdevcert.repository.OrderRepository;

import java.util.List;

@RestController
@RequestMapping(path = "/orders", produces = "application/json")
@CrossOrigin(origins = "*")
public class OrderController {

    private OrderRepository orderRepository;
    private OrderMessageProducerServiceImpl orderMessageProducerService;

    @Autowired
    public OrderController(OrderRepository orderRepository,OrderMessageProducerServiceImpl orderMessageProducerService) {
        this.orderRepository = orderRepository;
        this.orderMessageProducerService = orderMessageProducerService;
    }

    @PostMapping(consumes = "application/json")
    @ResponseStatus(HttpStatus.CREATED)
    public Order saveOrder(@RequestBody Order order) {
        orderMessageProducerService.sendOrder(order);
        return orderRepository.save(order);
    }

    @DeleteMapping("{/id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void deteleOrder(Long id) {
        try {
            orderRepository.deleteById(id);
        } catch (EmptyResultDataAccessException ex) {
        }
    }

    @GetMapping()
    public ResponseEntity<Iterable<Order>> getOrders(){
        return new ResponseEntity<Iterable<Order>>(orderRepository.findAll(),HttpStatus.OK);
    }
}