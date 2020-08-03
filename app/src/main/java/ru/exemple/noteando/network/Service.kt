package ru.exemple.noteando.network

import retrofit2.Retrofit
import ru.exemple.noteando.network.api.Api
import ru.exemple.noteando.network.api.RetrofitApi
import ru.exemple.noteando.network.dto.ArticleDto

class Service(private val retrofitApi: RetrofitApi) : Api {

    override fun getArticles(): List<ArticleDto> {
        val call = retrofitApi.loadArticles()
        return call.execute().body()!!
    }

    override fun getMainArticles(): List<ArticleDto> {
        val call = retrofitApi.loadMainArticles()
        return call.execute().body()!!
    }

    override fun requestDetailArticle(id: Int) {
        TODO("Not yet implemented")
    }

    override fun postArticle(title: String, description: String) {
        TODO("Not yet implemented")
    }
}