package com.example.appnewslistner.feature.data.mapper

import com.example.appnewslistner.feature.domain.ArticleModel
import com.example.appnewslistner.feature.data.model.ArticleRemoteModel

fun ArticleRemoteModel.toDomain() = ArticleModel(
    author = author ?: ""
    ,title = title ?: ""
    ,description = description ?: ""
    ,url = url ?: ""
    ,urlToImage = urlToImage ?: ""
    ,publishedAt = publishedAt ?:""
)