package ru.exemple.noteando.ui.articleList

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProviders
import ru.exemple.noteando.App
import ru.exemple.noteando.DETAIL_ARTICLE_FRAGMENT
import ru.exemple.noteando.R
import ru.exemple.noteando.network.api.Api
import ru.exemple.noteando.presenters.articleListPresenter.ArticleListPresenter
import ru.exemple.noteando.presenters.articleListPresenter.ArticleListPresenterImpl
import ru.exemple.noteando.ui.detailArticle.DetailArticleFragment

class ArticleListFragment : Fragment(), ArticleListViewImpl.OnAdapterItemClickListener {

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
        val service: Api
        activity?.let {
            service = (it.application as App).getDependencyRoot().service
            articleListPresenter = ArticleListPresenterImpl(service)
        }
    }

    private fun initView(view: View) {
        articleListView = ArticleListViewImpl(this, view)
    }

    private fun attachView(articleListView: ArticleListView) {
        articleListPresenter.attachView(articleListView)
    }

    private fun observePresenterLiveData() {
        articleListPresenter.getLiveData().observe(
            viewLifecycleOwner,
            Observer { articles ->
                articleListView.bindData(articles)
            }
        )
        articleListPresenter.bindArticleListView()
    }

    private fun bindView() {
        articleListPresenter.bindArticleListView()
    }

    override fun onAdapterItemClick() {
        parentFragmentManager.beginTransaction()
            .replace(R.id.activity_main__container, DetailArticleFragment(), DETAIL_ARTICLE_FRAGMENT)
            .addToBackStack(null)
            .commit()
    }
}