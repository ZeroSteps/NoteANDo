package ru.exemple.noteando.network.api

import io.reactivex.Observable
import io.reactivex.Single
import ru.exemple.noteando.article.Article
import ru.exemple.noteando.network.dto.ArticleDto

class ApiStubImpl : Api {

    override fun getArticles(): Single<List<ArticleDto>> {
        val articles = ArrayList<ArticleDto>()
        articles.add(ArticleDto(1, "Linear Layout", "What are you doing?"))
        articles.add(ArticleDto(2, "Linear Layout", "What are you doing?"))
        articles.add(ArticleDto(3, "Linear Layout", "What are you doing?"))
        articles.add(ArticleDto(4, "Linear Layout", "What are you doing?"))
        articles.add(ArticleDto(5, "Linear Layout", "What are you doing?"))
        return Single.just(articles)
    }

    override fun getMainArticles(): Single<List<ArticleDto>> {
        val articles = ArrayList<ArticleDto>()
        articles.add(ArticleDto(1, "CSS", "sadasdasdasdsadasd123"))
        articles.add(ArticleDto(2, "NoteJS", "zxczxczxczxczxczxczxczx321"))
        articles.add(ArticleDto(3, "Flutter", "zxczxczxczxczxczxczxczx456"))
        articles.add(ArticleDto(4, "Android", "zxczxczxczxczxczxczxczx11113"))
        articles.add(ArticleDto(5, "IOS", "zxczxczxczxczxczxczxczx11113"))
        return Single.just(articles)
    }

    override fun requestDetailArticle(id: Int) {
        TODO("Not yet implemented")
    }

    override fun postArticle(title: String, description: String) {
        TODO("Not yet implemented")
    }
}