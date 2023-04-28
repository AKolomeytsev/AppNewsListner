package com.example.appnewslistner.feature.news_screen

import android.util.Log
import androidx.lifecycle.viewModelScope
import com.example.appnewslistner.base.BaseViewModel
import com.example.appnewslistner.base.Event
import com.example.appnewslistner.feature.domain.ArticlesInteractor
import kotlinx.coroutines.launch

class MainScreenViewModel(private val interactor: ArticlesInteractor):BaseViewModel<ViewState>() {
    init {
        processDataEvent(DataEvent.LoadArticles)
    }
    override fun initialViewState() = ViewState(articles = emptyList())
    override fun reduce(event: Event, previousState: ViewState): ViewState? {
        when(event){
            is DataEvent.LoadArticles->{
                viewModelScope.launch {
                    interactor.getArticles().fold(
                        onError = {
                            Log.e("ERROR",it.localizedMessage)
                        }
                    , onSuccess = {
                        processDataEvent(DataEvent.OnLoadArticlesSucceed(it))
                        }
                    )
                }
                return null
            }
            is DataEvent.OnLoadArticlesSucceed->{
                return previousState.copy(articles = event.articles)
            }
            else->return null
        }
    }
}