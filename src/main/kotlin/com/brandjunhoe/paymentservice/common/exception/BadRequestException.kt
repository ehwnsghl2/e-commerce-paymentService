package com.brandjunhoe.paymentservice.common.exception

import com.brandjunhoe.paymentservice.common.code.ErrorCode


open class BadRequestException(val errorCode: ErrorCode) : RuntimeException()