package com.brandjunhoe.paymentservice.payment.presentation

import com.brandjunhoe.paymentservice.payment.application.PaymentService
import com.brandjunhoe.paymentservice.payment.presentation.dto.ReqPaymentDoneUpdateDTO
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.RequestBody
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController
import javax.servlet.http.HttpServletResponse
import javax.validation.Valid

/**
 * Create by DJH on 2022/06/03.
 */
@RestController
@RequestMapping("/v1/payment")
class PaymentController(val paymentService: PaymentService) {

    @PostMapping("/approve")
    fun updatePaymentApprove(
        response: HttpServletResponse,
        @RequestBody @Valid request: ReqPaymentDoneUpdateDTO
    ) {
        paymentService.updatePaymentDone(request.orderCode)
        response.sendRedirect("")
    }

}