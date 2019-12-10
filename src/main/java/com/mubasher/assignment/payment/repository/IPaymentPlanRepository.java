package com.mubasher.assignment.payment.repository;

import com.mubasher.assignment.domain.entity.PaymentMethod;
import com.mubasher.assignment.domain.entity.PaymentPlan;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface IPaymentPlanRepository extends JpaRepository<PaymentPlan, Long> {

}
