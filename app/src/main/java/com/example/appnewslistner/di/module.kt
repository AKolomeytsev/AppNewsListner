package com.example.appnewslistner.di

import android.util.Log
import androidx.room.Room
import com.example.appnewslistner.AppDataBase
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import org.koin.android.ext.koin.androidContext
import org.koin.dsl.module
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import java.util.Timer

private const val BASE_URL = "https://newsapi.org"
private const val API_KEY = "7b35f56c252642909449eeb5110c098a"
const val APP_DATABASE = "APP_DATABASE"
val networkModule = module{
    single<OkHttpClient>{
        OkHttpClient
            .Builder()
            .addInterceptor(
                HttpLoggingInterceptor{message->
                    Log.d("OkHttp",message)
                }.apply { setLevel(HttpLoggingInterceptor.Level.BODY)
                }
            )
            .build()
    }

    single<Retrofit>{
        Retrofit.Builder()
            .baseUrl(BASE_URL).addConverterFactory(GsonConverterFactory.create())
            .client(get<OkHttpClient>())
            .build()
    }
}

val databaseModule = module{
    single {
        Room
            .databaseBuilder(androidContext(), AppDataBase::class.java,APP_DATABASE)
            .fallbackToDestructiveMigration()
            .build()
    }
    single { get<AppDataBase>().bookmarksDao() }
}