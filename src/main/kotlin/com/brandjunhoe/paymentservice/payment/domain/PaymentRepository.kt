package com.brandjunhoe.paymentservice.payment.domain

/**
 * Create by DJH on 2022/05/12.
 */
interface PaymentRepository {
    fun save(payment: Payment) : Payment
}