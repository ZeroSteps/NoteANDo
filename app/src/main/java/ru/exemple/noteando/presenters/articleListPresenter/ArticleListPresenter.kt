package ru.exemple.noteando.presenters.articleListPresenter

import androidx.lifecycle.MutableLiveData
import ru.exemple.noteando.article.Article
import ru.exemple.noteando.presenters.Presenter

interface ArticleListPresenter: Presenter {

    fun getLiveData(): MutableLiveData<List<Article>>

    fun bindArticleListView()
}