package ru.exemple.noteando.network.api

import ru.exemple.noteando.article.Article
import ru.exemple.noteando.network.dto.ArticleDto

class ApiImpl: Api {

    override fun getArticles(): List<ArticleDto> {
        TODO("Not yet implemented")
    }

    override fun requestDetailArticle(id: Int) {
        TODO("Not yet implemented")
    }

    override fun postArticle(title: String, description: String) {
        TODO("Not yet implemented")
    }
}