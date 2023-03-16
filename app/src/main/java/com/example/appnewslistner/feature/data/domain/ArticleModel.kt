package com.example.appnewslistner.feature.data.domain

import com.google.gson.annotations.SerializedName
import java.net.URL

data class ArticleModel(
    val author:String?=""
    ,val title:String?=""
    ,val description:String?=""
    ,val url:String?=""
    )
