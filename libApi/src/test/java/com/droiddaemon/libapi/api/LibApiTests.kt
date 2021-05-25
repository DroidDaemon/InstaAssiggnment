package com.droiddaemon.libapi



import kotlinx.coroutines.runBlocking
import org.junit.Assert
import org.junit.Test


class LibApiTests {

  val api = LivApiClient.api

    @Test
    fun `fetch gellery hot data`() =  runBlocking{
      val response =   api.getGelleryData("hot")
        println(response.raw().toString())
        Assert.assertNotNull(response.body())
    }

  @Test
  fun `fetch gellery top data`() =  runBlocking{
    val response =   api.getGelleryData("top")
    println(response.raw().toString())
    Assert.assertNotNull(response.body())
  }


  @Test
  fun `fetch tag data`() =  runBlocking{
    val response =   api.getTags()
    println(response.raw().toString())
    Assert.assertNotNull(response.body())
  }


  @Test
  fun `fetch tag `() =  runBlocking{
    val response =   api.getTagGallery("trees")
    println(response.raw().toString())
    Assert.assertNotNull(response.body())
  }

}