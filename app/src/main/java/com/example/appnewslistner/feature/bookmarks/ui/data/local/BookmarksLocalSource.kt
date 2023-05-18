package com.example.appnewslistner.feature.bookmarks.ui.data.local

import com.example.appnewslistner.feature.bookmarks.ui.data.local.interfaces.IBookmarksDao
import com.example.appnewslistner.feature.bookmarks.ui.data.local.model.BookmarkEntity

class BookmarksLocalSource(private val bookmarksDao: IBookmarksDao) {
    suspend fun create(entity: BookmarkEntity){
        bookmarksDao.create(entity)
    }

    suspend fun read():List<BookmarkEntity>{
        return bookmarksDao.read()
    }

    suspend fun update(entity: BookmarkEntity){
        bookmarksDao.update(entity)
    }

    suspend fun delete(entity: BookmarkEntity){
        bookmarksDao.delete(entity)
    }
}