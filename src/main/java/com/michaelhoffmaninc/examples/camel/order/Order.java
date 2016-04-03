package com.michaelhoffmaninc.examples.camel.order;

/**
 * Bean for an order
 * 
 * @author Michael Hoffman
 *
 */
public class Order {

   private int orderId;
   private String orderNumber;

   /**
    * Default constructor
    */
   public Order() {
      super();
   }

   /**
    * Full constructor
    * 
    * @param orderId
    * @param orderNumber
    */
   public Order(int orderId, String orderNumber) {
      super();
      this.orderId = orderId;
      this.orderNumber = orderNumber;
   }

   /**
    * @return the orderId
    */
   public int getOrderId() {
      return orderId;
   }

   /**
    * @param orderId
    *           the orderId to set
    */
   public void setOrderId(int orderId) {
      this.orderId = orderId;
   }

   /**
    * @return the orderNumber
    */
   public String getOrderNumber() {
      return orderNumber;
   }

   /**
    * @param orderNumber
    *           the orderNumber to set
    */
   public void setOrderNumber(String orderNumber) {
      this.orderNumber = orderNumber;
   }
}
