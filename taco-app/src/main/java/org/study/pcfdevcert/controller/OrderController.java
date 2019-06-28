package org.study.pcfdevcert.controller;


import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.bind.support.SessionStatus;
import org.study.pcfdevcert.domain.Order;
import org.study.pcfdevcert.repository.OrderRepository;

import javax.validation.Valid;

@RequestMapping(path = "/orders")
@Controller
@SessionAttributes("order")
public class OrderController {

    Logger logger = LoggerFactory.getLogger(OrderController.class);

    private OrderRepository orderRepository;

    @Autowired
    public OrderController(OrderRepository orderRepository) {
        this.orderRepository = orderRepository;
    }

    @GetMapping(path = "/current")
    public String orderForm() {
        return "orderForm";
    }

    @PostMapping
    public String processOrders(@Valid Order order, BindingResult bindingResult,
                                SessionStatus sessionStatus) {
        if (bindingResult.hasErrors()) {
            logger.info("** Order has validaton errors **");
            return "orderForm";
        }

        logger.info("*********** Order Submitted ***********" + order);
        orderRepository.save(order);
        sessionStatus.setComplete();
        return "redirect:/design";
    }
}

