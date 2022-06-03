package com.brandjunhoe.paymentservice.consumer

import com.brandjunhoe.paymentservice.consumer.dto.PaymentSaveDTO
import com.brandjunhoe.paymentservice.payment.application.PaymentService
import com.fasterxml.jackson.databind.ObjectMapper
import org.apache.kafka.clients.consumer.ConsumerRecord
import org.springframework.kafka.annotation.KafkaListener
import org.springframework.kafka.listener.AcknowledgingMessageListener
import org.springframework.kafka.support.Acknowledgment
import org.springframework.stereotype.Component

/**
 * Create by DJH on 2022/04/18.
 */
@Component
class PaymentSaveConsumer(
    private val paymentService: PaymentService,
    private val objectMapper: ObjectMapper
) : AcknowledgingMessageListener<String, String> {


    @KafkaListener(
        topics = ["\${spring.kafka.consumer.topic}"],
        groupId = "\${spring.kafka.consumer.group-id}"
    )
    override fun onMessage(data: ConsumerRecord<String, String>, acknowledgment: Acknowledgment?) {
        val mileageSaveDTO = objectMapper.readValue(data.value(), PaymentSaveDTO::class.java)
        paymentService.save(mileageSaveDTO)
        acknowledgment?.acknowledge()
    }

}

// {"orderCode" : "orderCode", "type" : "PAYMENT", "method" : "CARD", "amount" : 10000}
