package com.oms.order_management_system.entity;

import jakarta.persistence.*;
import lombok.Data;
import org.hibernate.annotations.CreationTimestamp;

import java.math.BigDecimal;
import java.time.LocalDateTime;

@Entity
@Table(name = "service_orders")
@Data
public class ServiceOrder {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(unique = true,nullable = false)
    private String orderNumber;
    @Column(nullable = false)
    private Long subscriberId;
    @Column(nullable = false)
    private String planName;
    @Column(nullable = false)
    private String status;
    private BigDecimal totalAmount;
    @CreationTimestamp
    private LocalDateTime createdAt;
    @Column(nullable = false)
    private String orderType;
}
