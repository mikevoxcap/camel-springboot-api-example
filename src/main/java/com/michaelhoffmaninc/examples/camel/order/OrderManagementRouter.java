package com.michaelhoffmaninc.examples.camel.order;

import java.util.*;

import org.apache.camel.component.servlet.*;
import org.apache.camel.model.rest.*;
import org.apache.camel.spring.boot.*;
import org.apache.camel.swagger.servlet.*;
import org.springframework.boot.autoconfigure.*;
import org.springframework.boot.context.embedded.*;
import org.springframework.context.annotation.*;

/**
 * Spring boot application that defines the routes available for order
 * management.
 * 
 * @author Michael Hoffman
 *
 */
@SpringBootApplication
public class OrderManagementRouter extends FatJarRouter {

   @Override
   public void configure() {
      // Start by building an instance of RestConfigurationDefinition. Need to
      // specify the component we are going to use for enabling REST endpoints,
      // specifically CamelServlet in this case. Set the binding mode to JSON.
      restConfiguration().
            // Leverage the CamelServlet component for the REST DSL
            component("servlet").
            // Bind using JSON
            bindingMode(RestBindingMode.json).
            // I like pretty things...
            dataFormatProperty("prettyPrint", "true").
            // This is the context path to be used for Swagger API documentation
            apiContextPath("api-doc").
            // Properties for Swagger
            // Title of the API
      apiProperty("api.title", "Order Management API").
            // Version of the API
            apiProperty("api.version", "1.0.0").
            // CORS (resource sharing) enablement
            apiProperty("cors", "true").
            // Use localhost for calls
            apiProperty("host", "localhost:8080").
            // Set base path
            apiProperty("base.path", "camel-springboot-api-example/api");
      configureGetOrder();
      configurePostOrder();
   }

   protected void configureGetOrder() {
      // Definition of the get order endpoint
      rest("/order").
            // This is a GET method call for getting an order by order
            // ID.
      get("{id}").
            // Description of what this method does
            description("Retrieve an order by ID").
            // Define the output type that will be returned from this method
            outType(Order.class)
            // Define where the message is routed to as a URI. Here we use a
            // Spring Bean and define the bean method to invoke. Note that Camel
            // has converted the ID placeholder from the URL into a header
            // entry.
            .to("bean:orderManagementService?method=getOrder(${header.id})");
   }

   protected void configurePostOrder() {
      // Definition of the post order endpoint
      rest("/order").
            // This is a POST method call for submitting an order using the
            // order form
      post().
            // Description of what the method does
            description("Submit a new order").
            // Define the type used for input
            type(OrderForm.class).
            // Define the type used for output
            outType(Order.class).
            // Define where the message is routed to as a URI. Here we use a
            // Spring Bean and define the bean method to invoke. Note that Camel
            // will automatically bind the OrderForm input type from the
            // message.
      to("bean:orderManagementService?method=saveOrder(${body})");
   }

   @Bean
   public ServletRegistrationBean camelServletRegistrationBean() {
      ServletRegistrationBean registration = new ServletRegistrationBean(
            new CamelHttpTransportServlet(), "/api/*");
      registration.setName("CamelServlet");
      return registration;
   }

   @Bean
   public ServletRegistrationBean swaggerServletRegistrationBean() {
      ServletRegistrationBean registration = new ServletRegistrationBean(
            new RestSwaggerServlet(), "/api-docs/*");
      registration.setName("SwaggerServlet");
      return registration;
   }

   @Bean
   public FilterRegistrationBean filterRegistrationBean() {
      FilterRegistrationBean filterBean = new FilterRegistrationBean();
      filterBean.setFilter(new RestSwaggerCorsFilter());
      List<String> urlPatterns = new ArrayList<String>();
      urlPatterns.add("/camel-springboot-api-example/api-docs/*");
      urlPatterns.add("/camel-springboot-api-example/api/*");
      filterBean.setUrlPatterns(urlPatterns);
      return filterBean;
   }

}
