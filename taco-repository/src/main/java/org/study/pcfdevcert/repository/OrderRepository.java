package org.study.pcfdevcert.repository;

import org.springframework.data.repository.CrudRepository;
import org.study.pcfdevcert.domain.Order;

public interface OrderRepository
        extends CrudRepository<Order, Long> {

}
