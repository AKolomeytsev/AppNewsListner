package com.example.appnewslistner.feature.bookmarks.ui.data.local.mapper

import com.example.appnewslistner.feature.bookmarks.ui.data.local.model.BookmarkEntity
import com.example.appnewslistner.feature.data.model.ArticleRemoteModel
import com.example.appnewslistner.feature.domain.ArticleModel

fun BookmarkEntity.toDomain() = ArticleModel(
    author = author ?: ""
    ,title = title?:""
    ,description = description?:""
    ,url = url?:""
    ,urlToImage = urlToImage ?: ""
    ,publishedAt = publishedAt ?: ""

)

fun ArticleModel.toEntity() = BookmarkEntity(
    author = author ?: ""
    ,title = title ?: ""
    ,description = description ?: ""
    ,url = url ?: ""
    ,urlToImage = urlToImage ?: ""
    ,publishedAt = publishedAt ?: ""
)