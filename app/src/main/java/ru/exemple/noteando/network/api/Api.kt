package ru.exemple.noteando.network.api

import ru.exemple.noteando.article.Article
import ru.exemple.noteando.network.dto.ArticleDto

interface Api {

    fun getArticles(): List<ArticleDto>

    fun requestDetailArticle(id: Int)

    fun postArticle(title: String, description: String)
}