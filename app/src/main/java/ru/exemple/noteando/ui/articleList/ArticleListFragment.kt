package ru.exemple.noteando.ui.articleList

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.ViewModelProviders
import ru.exemple.noteando.App
import ru.exemple.noteando.R
import ru.exemple.noteando.api.Api
import ru.exemple.noteando.presenters.articleListPresenter.ArticleListPresenter
import ru.exemple.noteando.presenters.articleListPresenter.ArticleListPresenterImpl

class ArticleListFragment : Fragment() {

    private lateinit var articleListPresenter: ArticleListPresenter
    private lateinit var articleListView: ArticleListView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        initPresenter()
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val view = inflater.inflate(R.layout.fragment_article_list, container, false)
        initView(view)
        attachView(articleListView)
        observePresenterLiveData()
        bindView()
        return view
    }

    override fun onDestroy() {
        super.onDestroy()
        articleListPresenter.detachView()
    }

    private fun initPresenter() {
        val viewModel = ViewModelProviders.of(this)
            .get(ArticleListPresenterImpl.ArticleListViewModel::class.java)
        viewModel.articleListViewModel?.let {
            articleListPresenter = it
            return
        }
        val api: Api
        activity?.let {
            api = (it.application as App).getDependencyRoot().apiStubImpl
            articleListPresenter = ArticleListPresenterImpl(api)
        }
    }

    private fun initView(view: View) {
        articleListView = ArticleListViewImpl(view)
    }

    private fun attachView(articleListView: ArticleListView) {
        articleListPresenter.attachView(articleListView)
    }

    private fun observePresenterLiveData() {
        articleListPresenter.getLiveData().observe(
            this,
            Observer { articles ->
                articleListView.bindData(articles)
            }
        )
        articleListPresenter.bindArticleListView()
    }

    private fun bindView() {
        articleListPresenter.bindArticleListView()
    }
}