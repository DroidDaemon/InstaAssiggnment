package com.droiddaemon.libapi.responseModels

import com.squareup.moshi.Json
import com.squareup.moshi.JsonClass

@JsonClass(generateAdapter = true)
data class AdConfig(
    @Json(name = "highRiskFlags")
    val highRiskFlags: List<Any?>? = null,
    @Json(name = "safeFlags")
    val safeFlags: List<String?>? = null,
    @Json(name = "showsAds")
    val showsAds: Boolean? = null,
    @Json(name = "unsafeFlags")
    val unsafeFlags: List<String?>? = null,
    @Json(name = "wallUnsafeFlags")
    val wallUnsafeFlags: List<Any?>? = null
)