package ru.exemple.noteando.presenters.articleListPresenter

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.schedulers.Schedulers

import ru.exemple.noteando.network.api.Api
import ru.exemple.noteando.article.Article
import ru.exemple.noteando.presenters.articleListPresenter.util.ArticlesDtoConverter
import ru.exemple.noteando.ui.articleList.ArticleListView

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
//            TODO: handle IOE and NPE
            getArticles()
        }
    }

    private fun getArticles() {
        val dispose =
            service.getArticles()
                .subscribeOn(Schedulers.newThread())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe({ articlesDto ->
                    articles.addAll(
                        ArticlesDtoConverter()
                            .convertArticlesDto(articlesDto)
                    )
                    liveData.postValue(articles)
                },
                    {

                    }
                )
    }

    override fun attachView(articleListView: ArticleListView) {
        this.articleListView = articleListView
    }

    override fun detachView() {
        this.articleListView = null
    }

    class ArticleListViewModel : ViewModel() {
        var articleListViewModel: ArticleListPresenter? = null
    }
}