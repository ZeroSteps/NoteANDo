package ru.exemple.noteando.ui.articleList

import ru.exemple.noteando.article.Article
import ru.exemple.noteando.ui.ArticleView

interface ArticleListView: ArticleView {

    fun bindData(articles: List<Article>)
}