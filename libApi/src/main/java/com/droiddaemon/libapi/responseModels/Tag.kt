package com.droiddaemon.libapi.responseModels

import com.squareup.moshi.Json
import com.squareup.moshi.JsonClass


@JsonClass(generateAdapter = true)
data class Tag(
    @Json(name = "accent")
    val accent: String? = null,
    @Json(name = "background_hash")
    val backgroundHash: String? = null,
    @Json(name = "background_is_animated")
    val backgroundIsAnimated: Boolean? = null,
    @Json(name = "description")
    val description: String? = null,
    @Json(name = "display_name")
    val displayName: String? = null,
    @Json(name = "followers")
    val followers: Int? = null,
    @Json(name = "following")
    val following: Boolean? = null,
    @Json(name = "is_promoted")
    val isPromoted: Boolean? = null,
    @Json(name = "is_whitelisted")
    val isWhitelisted: Boolean? = null,
    @Json(name = "items")
    val items: List<Image>? = null,
    @Json(name = "logo_destination_url")
    val logoDestinationUrl: Any? = null,
    @Json(name = "logo_hash")
    val logoHash: Any? = null,
    @Json(name = "name")
    val name: String? = null,
    @Json(name = "thumbnail_hash")
    val thumbnailHash: Any? = null,
    @Json(name = "thumbnail_is_animated")
    val thumbnailIsAnimated: Boolean? = null,
    @Json(name = "total_items")
    val totalItems: Int? = null
)