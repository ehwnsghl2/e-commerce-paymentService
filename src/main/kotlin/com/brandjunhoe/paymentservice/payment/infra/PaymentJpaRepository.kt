package com.brandjunhoe.paymentservice.payment.infra

import com.brandjunhoe.paymentservice.payment.domain.Payment
import com.brandjunhoe.paymentservice.payment.domain.PaymentRepository
import org.springframework.data.jpa.repository.JpaRepository
import java.util.*

/**
 * Create by DJH on 2022/05/12.
 */
interface PaymentJpaRepository : JpaRepository<Payment, UUID>, PaymentRepository {
}