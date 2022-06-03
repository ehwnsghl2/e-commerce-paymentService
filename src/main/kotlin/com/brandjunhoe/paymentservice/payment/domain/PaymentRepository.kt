package com.brandjunhoe.paymentservice.payment.domain

import com.brandjunhoe.paymentservice.payment.domain.enum.PaymentStateEnum
import com.brandjunhoe.paymentservice.payment.domain.enum.PaymentTypeEnum

/**
 * Create by DJH on 2022/05/12.
 */
interface PaymentRepository {
    fun save(payment: Payment) : Payment
    fun findByOrderCodeAndTypeAndState(orderCode: String, type: PaymentTypeEnum, state: PaymentStateEnum) : Payment?
}