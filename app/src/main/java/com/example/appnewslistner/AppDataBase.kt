package com.example.appnewslistner

import androidx.room.Database
import androidx.room.RoomDatabase
import com.example.appnewslistner.feature.bookmarks.ui.data.local.interfaces.IBookmarksDao
import com.example.appnewslistner.feature.bookmarks.ui.data.local.model.BookmarkEntity

@Database(entities = [BookmarkEntity::class,],version = 1)
abstract class AppDataBase : RoomDatabase(){
    abstract fun bookmarksDao(): IBookmarksDao
}