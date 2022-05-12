package com.brandjunhoe.paymentservice.payment.domain.enum

/**
 * Create by DJH on 2022/05/12.
 */
enum class PaymentMethodEnum(val desc: String) {
    CARD("카드 결제"),
    CELLPHONE("휴대전화 결제"),
    PAY_KAKAO("휴대전화 결제"),
    PAY_LPAY("엘페이 결제"),
    PAY_NAVER("네이버페이 결제"),
    PAY_PAYCO("페이코 결제"),
    PAY_SAMSUNG("삼성페이 결제"),
    PAY_SSG("신세계페이 결제"),
    VBANK("가상계좌 결제")
}
