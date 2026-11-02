package com.oms.order_management_system.controller;

import com.oms.order_management_system.entity.ServiceOrder;
import com.oms.order_management_system.service.ServiceOrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/orders")
public class ServiceOrderController {

    @Autowired
    private ServiceOrderService serviceOrderService;

    // POST /api/orders - Create a new service order
    @PostMapping
    public ResponseEntity<ServiceOrder> createOrder(@RequestBody ServiceOrder serviceOrder) {
        ServiceOrder created = serviceOrderService.createOrder(serviceOrder);
        return new ResponseEntity<>(created, HttpStatus.CREATED);
    }

    // GET /api/orders - Get all service orders
    @GetMapping
    public List<ServiceOrder> getAllOrders() {
        return serviceOrderService.getAllOrders();
    }

    // GET /api/orders/{id} - Get order by ID
    @GetMapping("/{id}")
    public ServiceOrder getOrderById(@PathVariable Long id) {
        return serviceOrderService.getOrderById(id);
    }

    // GET /api/orders/subscriber/{subscriberId} - Get orders for a specific subscriber
    @GetMapping("/subscriber/{subscriberId}")
    public List<ServiceOrder> getOrdersBySubscriberId(@PathVariable Long subscriberId) {
        return serviceOrderService.getOrdersBySubscriberId(subscriberId);
    }

    // GET /api/orders/status/{status} - Get orders filtered by status
    @GetMapping("/status/{status}")
    public List<ServiceOrder> getOrdersByStatus(@PathVariable String status) {
        return serviceOrderService.getOrdersByStatus(status);
    }
}
