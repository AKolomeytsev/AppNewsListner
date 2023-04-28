package com.example.appnewslistner.feature.data.interfaces

import com.example.appnewslistner.feature.domain.ArticleModel
import com.example.appnewslistner.feature.data.model.ArticleRemoteModel
import com.example.appnewslistner.feature.data.model.ArticlesRemoteModel
import retrofit2.http.GET
import retrofit2.http.Query

interface INewsApi {
    @GET("/v2/top-headlines")
    suspend fun getNews(
        @Query("apiKey") apiKey: String = "7b35f56c252642909449eeb5110c098a",
        @Query("country") country: String = "ru"
    ): ArticlesRemoteModel
}