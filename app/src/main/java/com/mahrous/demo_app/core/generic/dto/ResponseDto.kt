package com.mahrous.demo_app.core.generic.dto

import com.squareup.moshi.Json
import com.squareup.moshi.JsonClass

@JsonClass(generateAdapter = true)
class ResponseDto<T : Any?> {
    @Json(name = "status")
    val status: Int = 0

    @Json(name = "code")
    val code: Int = 0

    @Json(name = "message")
    val message: String = ""

    @Json(name = "data")
    val data: T? = null

    @Json(name = "errors")
    val errors: List<String> = emptyList()
}
