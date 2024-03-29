package com.mubasher.assignment.payment.repository;

import com.mubasher.assignment.domain.entity.PaymentMethod;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface IPaymentMethodRepository extends JpaRepository<PaymentMethod, Long> {

}
