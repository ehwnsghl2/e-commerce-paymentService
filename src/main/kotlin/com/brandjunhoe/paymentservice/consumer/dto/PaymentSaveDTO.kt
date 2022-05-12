package com.brandjunhoe.paymentservice.consumer.dto

import com.brandjunhoe.paymentservice.payment.domain.Payment
import com.brandjunhoe.paymentservice.payment.domain.enum.PaymentMethodEnum
import com.brandjunhoe.paymentservice.payment.domain.enum.PaymentStateEnum
import com.brandjunhoe.paymentservice.payment.domain.enum.PaymentTypeEnum
import java.math.BigDecimal

/**
 * Create by DJH on 2022/05/12.
 */
class PaymentSaveDTO(
    val orderCode: String,
    val type: PaymentTypeEnum,
    val method: PaymentMethodEnum,
    val amount: BigDecimal,
) {

    fun toEntity(): Payment =
        Payment(orderCode, type, method, amount)


}