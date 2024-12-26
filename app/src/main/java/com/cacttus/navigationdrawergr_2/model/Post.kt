package com.cacttus.navigationdrawergr_2.model

import com.google.gson.annotations.SerializedName

data class Post(
    var id: Int,
    var userId: Int,
    var title: String,
    var body: String
)
