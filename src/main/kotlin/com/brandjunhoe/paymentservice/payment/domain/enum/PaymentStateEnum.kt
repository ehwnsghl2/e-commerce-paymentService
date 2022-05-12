package com.brandjunhoe.paymentservice.payment.domain.enum

/**
 * Create by DJH on 2022/05/12.
 */
enum class PaymentStateEnum(val desc: String) {
    READY("결제 대기"),
    DONE("결제 완료"),
    ERROR("결제 오류")
}
