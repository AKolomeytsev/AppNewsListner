package com.example.appnewslistner.feature.bookmarks.ui

import com.example.appnewslistner.base.Event
import com.example.appnewslistner.feature.domain.ArticleModel

data class ViewState(
    val bookmarksArticles:List<ArticleModel>
)

sealed class UiEvent()
sealed class DataEvent:Event{
    object LoadBookmarks:DataEvent()
    data class OnSuccesBookmarksLoaded(val bookmarksArticles: List<ArticleModel>):DataEvent()
    data class OnFailedBookmarksLoaded(val throwable: Throwable):DataEvent()

}

