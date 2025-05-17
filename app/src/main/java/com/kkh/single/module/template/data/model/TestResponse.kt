package com.kkh.single.module.template.data.model

import com.google.gson.annotations.SerializedName

data class TestResponse(
    @SerializedName("data")
    val data : Int
) : BaseResponse()
