package com.example.appnewslistner.feature.bookmarks.ui.data.local.domain

import com.example.appnewslistner.base.Either
import com.example.appnewslistner.base.attempt
import com.example.appnewslistner.feature.bookmarks.ui.data.local.interfaces.IBookmarksRepository

import com.example.appnewslistner.feature.domain.ArticleModel

class BookmarksIterator(private val bookmarksRepository: IBookmarksRepository) {
    suspend fun create(model: ArticleModel) {
        attempt{bookmarksRepository.create(model)}
    }

    suspend fun read(): Either<Throwable, List<ArticleModel>> {
        return attempt {  bookmarksRepository.read()}
    }

    suspend fun update(model: ArticleModel) {
        attempt{bookmarksRepository.update(model)}
    }

    suspend fun delete(model: ArticleModel) {
        attempt{bookmarksRepository.delete(model)}
    }
}