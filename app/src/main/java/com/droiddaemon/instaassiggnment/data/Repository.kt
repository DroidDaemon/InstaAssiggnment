package com.droiddaemon.instaassiggnment.data

import com.droiddaemon.libapi.LivApiClient
import com.droiddaemon.libapi.responseModels.Gallery
import com.droiddaemon.libapi.responseModels.GelleryResponse
import com.droiddaemon.libapi.responseModels.Image
import com.droiddaemon.libapi.responseModels.Tag

class Repository {

    val api = LivApiClient.api

    suspend fun fetchHotFeed() : List<Image>? {
       val response =  api.getGelleryData("hot")
         return response.body()?.data
    }

    suspend fun fetchTopFeed() : List<Image>?{
        val response =  api.getGelleryData("top")
        return response.body()?.data
    }

    suspend fun getTags() : List<Tag>?{
        val response =  api.getTags()
        return response.body()?.data?.tags
    }

    suspend fun getTagGallery(tagName : String) : List<Image>?{
        val response =  api.getTagGallery(tagName)
        return response.body()?.data?.items
    }
}