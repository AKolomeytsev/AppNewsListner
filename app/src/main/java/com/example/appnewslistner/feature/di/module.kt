package com.example.appnewslistner.feature.di

import com.example.appnewslistner.feature.data.ArticleRemoteSource
import com.example.appnewslistner.feature.data.ArticlesRepositoryImp
import com.example.appnewslistner.feature.data.domain.ArticlesInteractor
import com.example.appnewslistner.feature.data.interfaces.INewsApi
import com.example.appnewslistner.feature.data.interfaces.INewsRepository
import com.example.appnewslistner.feature.news_screen.MainScreenViewModel
import org.koin.androidx.viewmodel.dsl.viewModel
import org.koin.dsl.module
import retrofit2.Retrofit

val mainScreenModel = module{
    single{
        get<Retrofit>().create(INewsApi::class.java)
    }

    single<ArticleRemoteSource> {
        ArticleRemoteSource(api=get())
    }

    single<INewsRepository> {
        ArticlesRepositoryImp(source = get())
    }

    single<ArticlesInteractor> {
        ArticlesInteractor(repository = get())
    }

    viewModel {
        MainScreenViewModel(interactor = get())
    }
}