package com.michaelhoffmaninc.examples.camel.order;

import org.springframework.stereotype.*;

/**
 * Default implementation for order management.
 * 
 * @author Michael Hoffman
 *
 */
@Service("orderManagementService")
public class DefaultOrderManagementService implements OrderManagementService {

   @Override
   public Order getOrder(int id) {
      return new Order(1, "12345");
   }

   @Override
   public Order saveOrder(OrderForm orderForm) {
      if (orderForm.getOrderId() == null) {
         return new Order(2, orderForm.getOrderNumber());
      } else {
         return new Order(orderForm.getOrderId(), orderForm.getOrderNumber());
      }
   }

}
