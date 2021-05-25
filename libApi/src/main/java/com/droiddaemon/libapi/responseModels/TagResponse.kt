package com.droiddaemon.libapi.responseModels


import com.squareup.moshi.Json
import com.squareup.moshi.JsonClass

@JsonClass(generateAdapter = true)
data class TagResponse(
    @Json(name = "data")
    val `data`: Tag? = null,
    @Json(name = "status")
    val status: Int? = null,
    @Json(name = "success")
    val success: Boolean? = null
)