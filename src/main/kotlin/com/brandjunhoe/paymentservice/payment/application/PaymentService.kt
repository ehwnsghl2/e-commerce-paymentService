package com.brandjunhoe.paymentservice.payment.application

import com.brandjunhoe.paymentservice.consumer.dto.PaymentSaveDTO
import com.brandjunhoe.paymentservice.payment.application.exception.PaymentNotFoundException
import com.brandjunhoe.paymentservice.payment.domain.PaymentRepository
import com.brandjunhoe.paymentservice.payment.domain.enum.PaymentStateEnum
import com.brandjunhoe.paymentservice.payment.domain.enum.PaymentTypeEnum
import org.springframework.stereotype.Service

/**
 * Create by DJH on 2022/05/12.
 */
@Service
class PaymentService(private val paymentRepository: PaymentRepository) {


    fun save(request: PaymentSaveDTO) {
        paymentRepository.save(request.toEntity())
    }

    fun updatePaymentDone(orderCode: String) {
        val payment = paymentRepository.findByOrderCodeAndTypeAndState(orderCode, PaymentTypeEnum.PAYMENT, PaymentStateEnum.READY)
            ?: throw PaymentNotFoundException()

        payment.done()
    }



}