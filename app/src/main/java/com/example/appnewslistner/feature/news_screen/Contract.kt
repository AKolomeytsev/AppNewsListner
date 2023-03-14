package com.example.appnewslistner.feature.news_screen


import com.example.appnewslistner.base.Event
import com.example.appnewslistner.feature.data.domain.ArticleModel

data class ViewState(
    val articles:List<ArticleModel>
)

sealed class DataEvent: Event {
    object LoadArticles:DataEvent()
    data class OnLoadArticlesSucceed(val articles: List<ArticleModel>):DataEvent()
}