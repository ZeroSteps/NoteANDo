package ru.exemple.noteando.network.api

import retrofit2.Call
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import retrofit2.http.GET
import ru.exemple.noteando.BASE_URL_API
import ru.exemple.noteando.network.dto.ArticleDto

interface RetrofitApi {
    @GET("articles")
    fun loadArticles(): Call<List<ArticleDto>>

    companion object Factory {
        fun create(): RetrofitApi {
            val retrofit = Retrofit.Builder()
                .addConverterFactory(GsonConverterFactory.create())
                .baseUrl(BASE_URL_API)
                .build()

            return retrofit.create(RetrofitApi::class.java)
        }
    }
}