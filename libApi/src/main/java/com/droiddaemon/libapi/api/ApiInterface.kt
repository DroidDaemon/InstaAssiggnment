package com.droiddaemon.libapi.api

import com.droiddaemon.libapi.responseModels.GelleryResponse
import com.droiddaemon.libapi.responseModels.GelleryTagsResponse
import com.droiddaemon.libapi.responseModels.TagResponse
import jdk.nashorn.internal.objects.annotations.Getter
import retrofit2.Call
import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Path

interface ApiInterface {

    @GET("gallery/{section}")
   suspend fun getGelleryData(
@Path("section") section : String

    ): Response<GelleryResponse>

    @GET("tags")
    suspend fun getTags(): Response<GelleryTagsResponse>

    @GET("gallery/t/{tag}")
    suspend fun getTagGallery(
        @Path("tag") tag :String
    ): Response<TagResponse>
}