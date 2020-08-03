package ru.exemple.noteando.presenters.articleListPresenter

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import ru.exemple.noteando.network.api.Api
import ru.exemple.noteando.article.Article
import ru.exemple.noteando.ui.articleList.ArticleListView
import java.util.concurrent.TimeUnit

class ArticleListPresenterImpl(private val service: Api) : ArticleListPresenter {

    private var articleListView: ArticleListView? = null

    private val articles = ArrayList<Article>()
    private val liveData = MutableLiveData<List<Article>>()


    override fun getLiveData(): MutableLiveData<List<Article>> {
        return liveData
    }

    override fun bindArticleListView() {
        articleListView?.let {
            it.showLoading()
//            TODO: handle IO and NPE
            getArticles()
//            it.bindData(articles)
        }
    }

    private fun getArticles() {
        object : Thread() {
            override fun run() {
                sleep(1000)
                articles.addAll(ArticlesDtoConverter().convertArticlesDto(service.getArticles()))
                liveData.postValue(articles)
            }
        }.start()
    }

    override fun attachView(articleListView: ArticleListView) {
        this.articleListView = articleListView
    }

    override fun detachView() {
        this.articleListView = null
    }

    class ArticleListViewModel : ViewModel() {
        val articleListViewModel: ArticleListPresenter? = null
    }
}