package com.example.appnewslistner.feature.bookmarks.ui.data.local.model

import com.example.appnewslistner.feature.bookmarks.ui.data.local.BookmarksLocalSource
import com.example.appnewslistner.feature.bookmarks.ui.data.local.interfaces.IBookmarksRepository
import com.example.appnewslistner.feature.bookmarks.ui.data.local.mapper.toDomain
import com.example.appnewslistner.feature.bookmarks.ui.data.local.mapper.toEntity
import com.example.appnewslistner.feature.domain.ArticleModel

class BookmarksRepositoryImp(private val bookmarksLocalSource: BookmarksLocalSource):IBookmarksRepository {
    override suspend fun create(model: ArticleModel) {
        bookmarksLocalSource.create(model.toEntity())
    }

    override suspend fun read(): List<ArticleModel> {
        return bookmarksLocalSource.read().map { it.toDomain() }
    }

    override suspend fun update(model: ArticleModel) {
        bookmarksLocalSource.update(model.toEntity())
    }

    override suspend fun delete(model: ArticleModel) {
        bookmarksLocalSource.delete(model.toEntity())
    }
}