package com.example.appnewslistner.feature.bookmarks.ui.di

import com.example.appnewslistner.feature.bookmarks.ui.BookmarksScreenViewModel
import com.example.appnewslistner.feature.bookmarks.ui.data.local.BookmarksLocalSource
import com.example.appnewslistner.feature.bookmarks.ui.data.local.domain.BookmarksIterator
import com.example.appnewslistner.feature.bookmarks.ui.data.local.interfaces.IBookmarksRepository
import com.example.appnewslistner.feature.bookmarks.ui.data.local.model.BookmarksRepositoryImp
import org.koin.dsl.module

const val BOOKMARKS_TABLE = "BOOKMARKS_TABLE"

val bookmarksModule = module {

    single {
        BookmarksLocalSource(bookmarksDao = get())
    }

    single<IBookmarksRepository> {
        BookmarksRepositoryImp(bookmarksLocalSource =  get())
    }
    single {
        BookmarksIterator(bookmarksRepository = get())
    }
    single {
        BookmarksScreenViewModel(iterator = get())
    }
}