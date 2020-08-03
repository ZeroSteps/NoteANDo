package ru.exemple.noteando.network.api

import ru.exemple.noteando.article.Article
import ru.exemple.noteando.network.dto.ArticleDto

class ApiStubImpl: Api {

    override fun getArticles(): List<ArticleDto> {
        val articles = ArrayList<ArticleDto>()
        articles.add(ArticleDto(1, "what", "sadasdasdasdsadasd"))
        articles.add(ArticleDto(2, "what2", "zxczxczxczxczxczxczxczx"))
        articles.add(ArticleDto(3, "what3", "zxczxczxczxczxczxczxczx"))
        articles.add(ArticleDto(4, "what4", "zxczxczxczxczxczxczxczx123"))
        return articles
    }

    override fun requestDetailArticle(id: Int) {
        TODO("Not yet implemented")
    }

    override fun postArticle(title: String, description: String) {
        TODO("Not yet implemented")
    }
}