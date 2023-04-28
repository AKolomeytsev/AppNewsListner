package com.example.appnewslistner.feature.domain

import com.example.appnewslistner.base.Either
import com.example.appnewslistner.base.attempt
import com.example.appnewslistner.feature.data.interfaces.INewsRepository

class ArticlesInteractor(private val repository: INewsRepository) {
    suspend fun getArticles() = attempt { repository.getNews() }
}