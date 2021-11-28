package kz.iitu.order.controller;


//import io.swagger.annotations.Api;

import kz.iitu.order.config.OrderProducer;
import kz.iitu.order.config.OrderRequest;
import kz.iitu.order.model.Order;
import kz.iitu.order.service.OrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/orders")
//@Api(value = "Order Controller class", description = "This class allows to interact with Order")
public class OrderController {

    private final OrderProducer producer;
    private OrderService orderService;

    @Autowired
    public OrderController(OrderProducer producer, OrderService orderService) {
        this.producer = producer;
        this.orderService = orderService;
    }

    @GetMapping("/{id}")
    public ResponseEntity<?> getMedicineById(@PathVariable Long id) {
        return ResponseEntity.ok(orderService.getOrderById(id));
    }

    @GetMapping("/producer")
    public String sendMessageToKafkaTopic2(@RequestParam("orderId") Long orderId) {

//        Order order = orderService.getOrderById(orderId);

        OrderRequest bookRequest = new OrderRequest("1", orderService.getOrderById(orderId));
        this.producer.orderRequestNotify(bookRequest);
        return "Your request sent successful!";
    }
}
