package com.example.appnewslistner.feature.data

import com.example.appnewslistner.feature.data.interfaces.INewsApi
import com.example.appnewslistner.feature.data.model.ArticleRemoteModel

class ArticleRemoteSource(private val api:INewsApi) {
    suspend fun getArticles(): List<ArticleRemoteModel> {
        return api.getNews()
    }
}