package ru.exemple.noteando.network.api

import io.reactivex.Observable
import io.reactivex.Single
import ru.exemple.noteando.article.Article
import ru.exemple.noteando.network.dto.ArticleDto

interface Api {

    fun getArticles(): Single<List<ArticleDto>>

    fun getMainArticles(): Single<List<ArticleDto>>

    fun requestDetailArticle(id: Int)

    fun postArticle(title: String, description: String)
}