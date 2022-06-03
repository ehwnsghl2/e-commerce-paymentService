package com.brandjunhoe.paymentservice.common.exception

import com.brandjunhoe.paymentservice.common.code.ErrorCode


open class DataNotFoundException : RuntimeException() {
    val errorCode: ErrorCode = ErrorCode.DATA_NOT_FOUND
}