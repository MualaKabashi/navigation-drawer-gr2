package com.cacttus.navigationdrawergr_2.api

import com.cacttus.navigationdrawergr_2.model.Post
import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Path

interface ServiceApi {
    @GET("posts")
    fun getPosts(): Call<List<Post>>

    @GET("posts/{id}")
    fun getPostById(@Path("id") id: Int): Call<Post>

//    fun getCommentsByPostId(): Call<List<Post>>
}