package ru.exemple.noteando.presenters.articleListPresenter.util

import ru.exemple.noteando.R
import ru.exemple.noteando.article.Article
import ru.exemple.noteando.network.dto.ArticleDto

class ArticlesDtoConverter {
    fun convertArticlesDto(articlesDto: List<ArticleDto>): List< Article> {
        val articles = ArrayList<Article>()
        for (articleDto in articlesDto) {
            articles.add(Article(articleDto.id, articleDto.title, articleDto.description, arrayOf("Sport", "News", "Hot"), R.drawable.ic_baseline_computer_24))
        }
        return articles
    }
}