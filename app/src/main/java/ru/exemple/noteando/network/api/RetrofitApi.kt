package ru.exemple.noteando.network.api

import io.reactivex.Observable
import io.reactivex.Single
import retrofit2.Call
import retrofit2.Retrofit
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory
import retrofit2.converter.gson.GsonConverterFactory
import retrofit2.http.GET
import ru.exemple.noteando.BASE_URL_API
import ru.exemple.noteando.network.dto.ArticleDto

interface RetrofitApi {

    @GET("articles")
    fun loadArticles(): Single<List<ArticleDto>>

    @GET("main_articles")
    fun loadMainArticles(): Call<List<ArticleDto>>

    companion object Factory {
        fun create(): RetrofitApi {
            val retrofit = Retrofit.Builder()
                .addConverterFactory(GsonConverterFactory.create())
                .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
                .baseUrl(BASE_URL_API)
                .build()

            return retrofit.create(RetrofitApi::class.java)
        }
    }
}