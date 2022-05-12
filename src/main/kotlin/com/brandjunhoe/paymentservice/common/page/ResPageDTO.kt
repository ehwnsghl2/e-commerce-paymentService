package com.brandjunhoe.paymentservice.common.page


data class ResPageDTO<T>(private val total: TotalPageDTO, private val data: T)