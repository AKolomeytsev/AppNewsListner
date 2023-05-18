package com.example.appnewslistner.feature.bookmarks.ui

import androidx.lifecycle.viewModelScope
import com.example.appnewslistner.base.BaseViewModel
import com.example.appnewslistner.base.Event
import com.example.appnewslistner.feature.bookmarks.ui.data.local.domain.BookmarksIterator
import com.example.appnewslistner.feature.bookmarks.ui.domain.DataEvent
import com.example.appnewslistner.feature.bookmarks.ui.domain.ViewState
import com.example.appnewslistner.feature.domain.ArticlesInteractor
import kotlinx.coroutines.launch

class BookmarksScreenViewModel(private val iterator:BookmarksIterator):BaseViewModel<ViewState>() {

    init {
        processDataEvent(DataEvent.LoadBookmarks)
    }
    override fun initialViewState(): ViewState = ViewState(bookmarksArticles = emptyList())

    override fun reduce(event: Event, previousState: ViewState): ViewState? {
        when(event){
            DataEvent.LoadBookmarks->{
                viewModelScope.launch {
                    iterator.read().fold(
                        onError = {},
                        onSuccess = {
                            processDataEvent(DataEvent.OnSuccesBookmarksLoaded(it))
                        }
                    )
                }
                return null
            }
            is DataEvent.OnSuccesBookmarksLoaded->{
                return previousState.copy(event.bookmarksArticles)
            }
            else->return null
        }

    }
}