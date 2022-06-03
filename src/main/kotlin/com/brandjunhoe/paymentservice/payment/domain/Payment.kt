package com.brandjunhoe.paymentservice.payment.domain

import com.brandjunhoe.paymentservice.common.domain.DateColumnEntity
import com.brandjunhoe.paymentservice.common.domain.DateDeleteColumnEntity
import com.brandjunhoe.paymentservice.payment.domain.enum.PaymentMethodEnum
import com.brandjunhoe.paymentservice.payment.domain.enum.PaymentStateEnum
import com.brandjunhoe.paymentservice.payment.domain.enum.PaymentTypeEnum
import org.hibernate.annotations.GenericGenerator
import org.hibernate.annotations.Where
import java.math.BigDecimal
import java.util.*
import javax.persistence.*

@Entity
@Table(name = "payment")
class Payment(

    @Column(name = "order_code", length = 255, nullable = false)
    val orderCode: String,

    @Enumerated(EnumType.STRING)
    @Column(name = "type", columnDefinition = "enum", nullable = false)
    val type: PaymentTypeEnum,

    @Enumerated(EnumType.STRING)
    @Column(name = "method", columnDefinition = "enum", nullable = false)
    val method: PaymentMethodEnum,

    state: PaymentStateEnum,

    @Column(name = "amount")
    val amount: BigDecimal,

    @Id
    @GeneratedValue(generator = "uuid2")
    @GenericGenerator(name = "uuid2", strategy = "uuid2")
    @Column(columnDefinition = "BINARY(16)")
    val id: UUID = UUID.randomUUID()


) : DateColumnEntity() {

    constructor(
        orderCode: String,
        type: PaymentTypeEnum,
        method: PaymentMethodEnum,
        amount: BigDecimal,
    ) : this(
        orderCode,
        type,
        method,
        PaymentStateEnum.READY,
        amount
    ) {
        paymentDate = Date()
    }

    @Enumerated(EnumType.STRING)
    @Column(name = "state", columnDefinition = "enum", nullable = false)
    var state: PaymentStateEnum = state
        protected set

    @Column(name = "payment_date")
    var paymentDate: Date? = null
        protected set


    fun done() {
        this.state = PaymentStateEnum.DONE
    }

    fun error() {
        this.state = PaymentStateEnum.ERROR
    }


}