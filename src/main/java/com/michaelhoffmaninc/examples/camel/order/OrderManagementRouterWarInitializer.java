package com.michaelhoffmaninc.examples.camel.order;

import org.apache.camel.spring.boot.*;

/**
 * Extends Spring Boot's SpringBootServletInitializer for initializing the web
 * application, providing the ability to initialize the Camel router for order
 * management.
 * 
 * @author Michael Hoffman
 *
 */
public class OrderManagementRouterWarInitializer extends FatWarInitializer {

   @Override
   protected Class<? extends FatJarRouter> routerClass() {
      return OrderManagementRouter.class;
   }

}
