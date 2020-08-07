package ru.exemple.noteando.presenters.articleListPresenter

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import ru.exemple.noteando.article.Article
import ru.exemple.noteando.network.api.Api
import ru.exemple.noteando.ui.articleList.ArticleListView

class MainArticleListPresenterImpl(private val service: Api) : ArticleListPresenter {

    private var mainArticleListView: ArticleListView? = null

    private val mainArticles = ArrayList<Article>()
    private val liveData = MutableLiveData<List<Article>>()

    override fun getLiveData(): MutableLiveData<List<Article>> {
        return liveData
    }

    override fun bindArticleListView() {
        mainArticleListView?.let {
            it.showLoading()
//            TODO: handle IOE and NPE
            getArticles()
        }
    }

    private fun getArticles() {
        object : Thread() {
            override fun run() {
                sleep(1000)
                mainArticles.addAll(ArticlesDtoConverter().convertArticlesDto(service.getMainArticles()))
                liveData.postValue(mainArticles)
            }
        }.start()
    }

    override fun attachView(articleListView: ArticleListView) {
        this.mainArticleListView = articleListView
    }

    override fun detachView() {
        mainArticleListView = null
    }

    class MainArticleListViewModel : ViewModel() {
        var mainArticleListPresenter: ArticleListPresenter? = null
    }
}