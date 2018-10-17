package com.example.yida.kaiyanapp.net.exception

/**
 * Created by yida on 2018/8/31.
 */
class ApiException : RuntimeException {

    private var code: Int? = null

    constructor(throwable: Throwable, code: Int): super(throwable) {
        this.code = code
    }

    constructor(message: String): super(Throwable(message))
}