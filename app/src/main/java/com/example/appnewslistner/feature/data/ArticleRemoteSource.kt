package com.example.appnewslistner.feature.data

import com.example.appnewslistner.feature.domain.ArticleModel
import com.example.appnewslistner.feature.data.interfaces.INewsApi
import com.example.appnewslistner.feature.data.model.ArticleRemoteModel
import com.example.appnewslistner.feature.data.model.ArticlesRemoteModel

class ArticleRemoteSource(private val api:INewsApi) {
    suspend fun getArticles(): ArticlesRemoteModel {
        return api.getNews()
    }
}