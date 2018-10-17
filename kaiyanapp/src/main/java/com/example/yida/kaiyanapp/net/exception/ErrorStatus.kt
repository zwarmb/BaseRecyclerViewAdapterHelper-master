package com.example.yida.kaiyanapp.net.exception

/**
 * Created by yida on 2018/8/31.
 */
object ErrorStatus {

    /**
     * 相应成功
     */
    @JvmField // 提示kotlin语法不要生成getter/setter 方法, 并将其作为一个字段公开
    val SUCCESS = 0

    /**
     * 未知错误
     */
    @JvmField
    val UNKNOWN_ERROR = 1002

    /**
     * 服务器内部错误
     */
    @JvmField
    val SERVER_ERROR = 1003

    /**
     * 网络连接超时
     */
    @JvmField
    val NETWORK_ERROR = 1004

    /**
     * API 解析异常 ( 或者第三方数据结构更改 ) 等其他异常
     */
    @JvmField
    val API_ERROR = 1005
}