package com.droiddaemon.libapi.responseModels


import com.squareup.moshi.Json
import com.squareup.moshi.JsonClass

@JsonClass(generateAdapter = true)
data class GelleryResponse(
    @Json(name = "data")
    val `data`: List<Image>? = null,
    @Json(name = "status")
    val status: Int? = null,
    @Json(name = "success")
    val success: Boolean? = null
)