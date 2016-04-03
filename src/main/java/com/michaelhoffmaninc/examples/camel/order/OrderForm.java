package com.michaelhoffmaninc.examples.camel.order;

/**
 * Form for posting a new order
 * 
 * @author Michael Hoffman
 *
 */
public class OrderForm {

   private Integer orderId;
   private String orderNumber;

   /**
    * Default constructor
    */
   public OrderForm() {
      super();
   }

   /**
    * Constructor when no ID exists, for new order
    * 
    * @param orderNumber
    */
   public OrderForm(String orderNumber) {
      super();
      this.orderNumber = orderNumber;
   }

   /**
    * Full constructor
    * 
    * @param orderId
    * @param orderNumber
    */
   public OrderForm(Integer orderId, String orderNumber) {
      super();
      this.orderId = orderId;
      this.orderNumber = orderNumber;
   }

   /**
    * @return the orderId
    */
   public Integer getOrderId() {
      return orderId;
   }

   /**
    * @param orderId
    *           the orderId to set
    */
   public void setOrderId(Integer orderId) {
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
