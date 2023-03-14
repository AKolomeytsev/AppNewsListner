package com.example.appnewslistner.feature.data.interfaces

import com.example.appnewslistner.feature.data.domain.ArticleModel

interface INewsRepository {
    suspend fun getNews():List<ArticleModel>
}