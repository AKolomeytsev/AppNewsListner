package com.example.appnewslistner.feature.data.model

import com.google.gson.annotations.SerializedName

data class ArticleRemoteModel (
    @SerializedName("autor")
    val autor:String?
    ,@SerializedName("title")
    val title:String?
    ,@SerializedName("description")
    val description:String?
    ,@SerializedName("url")
    val url:String?
    )