package org.study.pcfdevcert;

import org.study.pcfdevcert.domain.Order;

public interface OrderMessagingService {

    void sendOrder(Order order);
}
