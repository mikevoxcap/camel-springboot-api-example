package com.michaelhoffmaninc.examples.camel.order;

/**
 * Interface for services to process orders as part of order management.
 * 
 * @author Michael Hoffman
 *
 */
public interface OrderManagementService {

   /**
    * Retrieves an order by the order ID passed.
    * 
    * @param id
    * @return
    */
   Order getOrder(int id);

   /**
    * Saves an order, either creating it if no ID was passed or updating it if
    * an ID was passed.
    * 
    * @param orderForm
    * @return
    */
   Order saveOrder(OrderForm orderForm);
}
