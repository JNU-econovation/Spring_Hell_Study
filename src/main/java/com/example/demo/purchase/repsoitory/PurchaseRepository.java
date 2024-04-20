package com.example.demo.purchase.repsoitory;

import com.example.demo.purchase.domain.Purchase;
import com.example.demo.user.domain.UserRole;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface PurchaseRepository extends JpaRepository<Purchase, Long> {
    @Query("select p from Purchase p where p.user.userRole = :userRole")
    List<Purchase> findByUserRole(UserRole userRole);
}
