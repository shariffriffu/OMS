package com.oms.order_management_system.service;

import com.oms.order_management_system.entity.ServiceOrder;
import com.oms.order_management_system.exception.ResourceNotFoundException;
import com.oms.order_management_system.repository.ServiceOrderRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;

@Service
public class ServiceOrderService {

    @Autowired
    private ServiceOrderRepository serviceOrderRepository;

    public ServiceOrder createOrder(ServiceOrder serviceOrder) {
        if (serviceOrder.getOrderNumber() == null || serviceOrder.getOrderNumber().isBlank()) {
            serviceOrder.setOrderNumber("ORD-" + UUID.randomUUID().toString().substring(0, 8).toUpperCase());
        }
        if (serviceOrder.getStatus() == null || serviceOrder.getStatus().isBlank()) {
            serviceOrder.setStatus("PENDING");
        }
        return serviceOrderRepository.save(serviceOrder);
    }

    public List<ServiceOrder> getAllOrders() {
        return serviceOrderRepository.findAll();
    }

    public ServiceOrder getOrderById(Long id) {
        return serviceOrderRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Service order not found with id: " + id));
    }

    public List<ServiceOrder> getOrdersBySubscriberId(Long subscriberId) {
        return serviceOrderRepository.findBySubscriberId(subscriberId);
    }

    public List<ServiceOrder> getOrdersByStatus(String status) {
        return serviceOrderRepository.findByStatus(status);
    }
}
