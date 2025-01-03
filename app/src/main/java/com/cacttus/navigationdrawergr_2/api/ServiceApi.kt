package com.cacttus.navigationdrawergr_2.api

import com.cacttus.navigationdrawergr_2.model.Post
import retrofit2.Call
import retrofit2.http.GET

interface ServiceApi {
    @GET("posts")
    fun getPosts(): Call<List<Post>>
}