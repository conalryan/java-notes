package com.conal.ryan.cxfdemo.endpoint;

import com.conal.ryan.cxfdemo.service.OrderService;
import com.ryan.conal.schema.order.OrderInquiryResponseType;
import com.ryan.conal.schema.order.OrderInquiryType;
import com.ryan.conal.service.orders.Orders;
import org.springframework.beans.factory.annotation.Autowired;

import javax.jws.WebService;

/**
 * Default implementation of the Orders interface
 * The class is annotated with the JAX-WS web service annotation.
 * The values for the port name and service name come from the service and port WSDL elements.
 * The endpoint interface value is the fully qualified name for the Orders interface.
 */
@WebService(portName = "OrdersSOAP",
        serviceName = "Orders",
        endpointInterface = "com.ryan.conal.service.orders.Orders",
        targetNamespace = "http://www.conal.ryan.com/service/Orders/")
public class DefaultOrdersEndpoint implements Orders {

    // Autowire allows Spring to inject the order service containing core business logic.
    @Autowired
    private OrderService orderService;

    @Override
    public OrderInquiryResponseType processOrderPlacement(OrderInquiryType orderInquiry) {

        // This method is the implementation for processing an order. It is
        // responsible for processing the message. At this time, it just routes
        // the call to our business logic service to complete the task.
        OrderInquiryResponseType response = orderService.processOrder(
                orderInquiry.getUniqueOrderId(), orderInquiry.getOrderQuantity(),
                orderInquiry.getAccountId(), orderInquiry.getEan13());
        return response;
    }
}