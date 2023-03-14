package com.example.appnewslistner.feature.data

import com.example.appnewslistner.feature.data.domain.ArticleModel
import com.example.appnewslistner.feature.data.interfaces.INewsRepository
import com.example.appnewslistner.feature.data.mapper.toDomain

class ArticlesRepositoryImp(private val source: ArticleRemoteSource):INewsRepository {
    override suspend fun getNews(): List<ArticleModel> {
        return source.getArticles().map { it.toDomain() }
    }

}