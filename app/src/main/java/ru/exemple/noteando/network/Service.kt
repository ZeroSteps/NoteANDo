package ru.exemple.noteando.network

import ru.exemple.noteando.network.api.Api
import ru.exemple.noteando.network.api.RetrofitApi
import ru.exemple.noteando.network.dto.ArticleDto

class Service: Api {

    override fun getArticles(): List<ArticleDto>  {
        val retrofitApi = RetrofitApi.create()
        val call = retrofitApi.loadArticles()
        return call.execute().body()!!
    }

    override fun requestDetailArticle(id: Int) {
        TODO("Not yet implemented")
    }

    override fun postArticle(title: String, description: String) {
        TODO("Not yet implemented")
    }
}