package com.oms.order_management_system.service;

import com.oms.order_management_system.repository.ServiceRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ServiceOrder {
    @Autowired
    private ServiceRepository.ServiceRepository serviceRepository;

    public Service createOrder( ServiceOrder serviceOrder){

        return serviceRepository.save(serviceOrder);
    }

}
