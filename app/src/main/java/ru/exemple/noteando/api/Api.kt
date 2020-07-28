package ru.exemple.noteando.api

import ru.exemple.noteando.article.Article

interface Api {

    fun getArticles(): List<Article>

    fun requestDetailArticle(id: Int)

    fun postArticle(title: String, description: String)
}