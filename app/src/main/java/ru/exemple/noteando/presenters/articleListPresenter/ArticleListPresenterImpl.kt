package ru.exemple.noteando.presenters.articleListPresenter

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import ru.exemple.noteando.api.Api
import ru.exemple.noteando.article.Article
import ru.exemple.noteando.ui.articleList.ArticleListView

class ArticleListPresenterImpl(private val api: Api): ArticleListPresenter {

    private var articleListView: ArticleListView? = null

    private val articles = ArrayList<Article>()
    private val liveData = MutableLiveData<List<Article>>()


    override fun getLiveData(): MutableLiveData<List<Article>> {
        return liveData
    }

    override fun bindArticleListView() {
        articleListView?.let {
            it.showLoading()
            getArticles()
            it.bindData(articles)
        }
    }

    private fun getArticles(): List<Article> {
        this.articles.clear()
        this.articles.addAll(api.getArticles())
        return articles
    }

    override fun attachView(articleListView: ArticleListView) {
        this.articleListView = articleListView
    }

    override fun detachView() {
        this.articleListView = null
    }

    class ArticleListViewModel: ViewModel() {
        val articleListViewModel: ArticleListPresenter? = null
    }
}