package ru.exemple.noteando.api

import ru.exemple.noteando.article.Article

class ApiStubImpl: Api {

    override fun getArticles(): List<Article> {
        val articles = ArrayList<Article>()
        articles.add(Article(1, "what", "sadasdasdasdsadasd"))
        articles.add(Article(2, "what2", "zxczxczxczxczxczxczxczx"))
        articles.add(Article(3, "what3", "zxczxczxczxczxczxczxczx"))
        articles.add(Article(4, "what4", "zxczxczxczxczxczxczxczx123"))
        return articles
    }

    override fun requestDetailArticle(id: Int) {
        TODO("Not yet implemented")
    }

    override fun postArticle(title: String, description: String) {
        TODO("Not yet implemented")
    }
}