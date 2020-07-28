package ru.exemple.noteando.presenters

import ru.exemple.noteando.ui.articleList.ArticleListView

interface Presenter {

    fun attachView(articleListView: ArticleListView)

    fun detachView()
}