package com.oms.order_management_system.repository;

import com.oms.order_management_system.entity.Customer;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import java.util.Optional;

@Repository
public interface CustomerRepository extends JpaRepository<Customer, Long> {

    // This automatically creates a query: SELECT * FROM customers WHERE email = ?
    Optional<Customer> findByEmail(String email);
}