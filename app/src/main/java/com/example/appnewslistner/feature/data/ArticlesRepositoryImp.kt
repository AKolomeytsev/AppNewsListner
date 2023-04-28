package com.example.appnewslistner.feature.data

import com.example.appnewslistner.feature.domain.ArticleModel
import com.example.appnewslistner.feature.data.interfaces.INewsRepository
import com.example.appnewslistner.feature.data.mapper.toDomain
import com.example.appnewslistner.feature.data.model.ArticleRemoteModel

class ArticlesRepositoryImp(private val source: ArticleRemoteSource) : INewsRepository {
    override suspend fun getNews(): List<ArticleModel> {
        return source.getArticles().articlesList.map { it.toDomain() }
    }
}