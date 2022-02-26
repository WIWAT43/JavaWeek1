package com.wiwats.shopping.payment.repository;

import com.wiwats.shopping.payment.model.PaymentTransaction;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PaymentTransactionRepository extends JpaRepository<PaymentTransaction,Long> {
}
