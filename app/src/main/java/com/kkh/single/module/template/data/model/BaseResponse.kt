package com.kkh.single.module.template.data.model

import com.google.gson.annotations.SerializedName

abstract class BaseResponse(
    @SerializedName("returnCode")
    open val returnCode: String = "",
    @SerializedName("returnMessage")
    open val returnMessage: String = "",
    @SerializedName("datetime")
    open val datetime: String = "0",
)

data class Response(
    @SerializedName("data")
    val data: Any?
): BaseResponse()