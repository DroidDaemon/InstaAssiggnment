package com.droiddaemon.libapi.responseModels


import com.squareup.moshi.Json
import com.squareup.moshi.JsonClass

@JsonClass(generateAdapter = true)
data class GelleryTagsResponse(
    @Json(name = "data")
    val `data`: Data? = null,
    @Json(name = "status")
    val status: Int? = null,
    @Json(name = "success")
    val success: Boolean? = null
) {
    @JsonClass(generateAdapter = true)
    data class Data(
        @Json(name = "featured")
        val featured: String? = null,
        @Json(name = "galleries")
        val galleries: List<Gallery>? = null,
        @Json(name = "tags")
        val tags: List<Tag>? = null
    )
}