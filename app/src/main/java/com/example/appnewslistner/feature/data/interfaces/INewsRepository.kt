package com.example.appnewslistner.feature.data.interfaces

import com.example.appnewslistner.feature.domain.ArticleModel
import com.example.appnewslistner.feature.data.model.ArticleRemoteModel

interface INewsRepository {
    suspend fun getNews(): List<ArticleModel>
}