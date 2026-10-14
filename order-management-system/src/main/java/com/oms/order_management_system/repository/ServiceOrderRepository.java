package com.oms.order_management_system.repository;

import com.oms.order_management_system.entity.ServiceOrder;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ServiceOrderRepository extends JpaRepository<ServiceOrder,Long> {

    List <ServiceOrder> findBySubscriberId(Long subscriberId);

    List<ServiceOrder> findByStatus(String status);



}
