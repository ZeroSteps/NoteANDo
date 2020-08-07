package ru.exemple.noteando.network

import io.reactivex.Observable
import io.reactivex.Single
import retrofit2.Retrofit
import ru.exemple.noteando.article.Article
import ru.exemple.noteando.network.api.Api
import ru.exemple.noteando.network.api.RetrofitApi
import ru.exemple.noteando.network.dto.ArticleDto

class Service(private val retrofitApi: RetrofitApi) : Api {

    override fun getArticles(): Single<List<ArticleDto>> {
        retrofitApi.loadArticles()
        return retrofitApi.loadArticles()
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