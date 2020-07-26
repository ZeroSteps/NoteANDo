package ru.exemple.noteando.api

interface Api {

    fun requestArticles()

    fun requestDetailArticle(id: Int)

    fun postArticle(title: String, description: String)
}