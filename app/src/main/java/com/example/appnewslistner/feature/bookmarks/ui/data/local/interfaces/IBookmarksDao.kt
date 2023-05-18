package com.example.appnewslistner.feature.bookmarks.ui.data.local.interfaces

import androidx.room.*
import com.example.appnewslistner.feature.bookmarks.ui.data.local.model.BookmarkEntity
import com.example.appnewslistner.feature.bookmarks.ui.di.BOOKMARKS_TABLE

@Dao
interface IBookmarksDao {

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun create(entity: BookmarkEntity)
    @Query("SELECT * FROM $BOOKMARKS_TABLE")
    suspend fun read():List<BookmarkEntity>
    @Update
    suspend fun update(entity: BookmarkEntity)
    @Delete
    suspend fun delete(entity: BookmarkEntity)

}