package com.brandjunhoe.paymentservice.payment.presentation.dto

import javax.validation.constraints.NotBlank

/**
 * Create by DJH on 2022/03/16.
 */
data class ReqPaymentDoneUpdateDTO(

    @field:NotBlank
    val orderCode: String

)
