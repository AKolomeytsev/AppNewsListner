package com.example.appnewslistner.feature.bookmarks.ui.data.local.interfaces

import com.example.appnewslistner.feature.bookmarks.ui.data.local.model.BookmarkEntity
import com.example.appnewslistner.feature.domain.ArticleModel

interface IBookmarksRepository {
    suspend fun create(entity: ArticleModel)

    suspend fun read():List<ArticleModel>

    suspend fun update(entity: ArticleModel)

    suspend fun delete(entity: ArticleModel)
}