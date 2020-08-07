package ru.exemple.noteando.ui.articleList

import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import ru.exemple.noteando.App
import ru.exemple.noteando.DETAIL_ARTICLE_FRAGMENT
import ru.exemple.noteando.MY_LOG_TAG
import ru.exemple.noteando.R
import ru.exemple.noteando.network.api.Api
import ru.exemple.noteando.presenters.articleListPresenter.ArticleListPresenter
import ru.exemple.noteando.presenters.articleListPresenter.ArticleListPresenterImpl
import ru.exemple.noteando.presenters.articleListPresenter.MainArticleListPresenterImpl
import ru.exemple.noteando.ui.detailArticle.DetailArticleFragment

class ArticleListFragment : Fragment(), ArticleListViewImpl.OnAdapterItemClickListener,
    MainArticleListViewImpl.OnMainAdapterItemClickListener {

    private lateinit var articleListPresenter: ArticleListPresenter
    private lateinit var mainArticleListPresenter: ArticleListPresenter
    private lateinit var articleListView: ArticleListView
    private lateinit var mainArticleListView: ArticleListView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        initPresenter()
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val view = inflater.inflate(R.layout.fragment_article_list, container, false)
        initViews(view)
        attachArticleListView(articleListView)
        attachMainArticleListView(mainArticleListView)
        observePresentersLiveData()
        return view
    }

    override fun onDestroy() {
        super.onDestroy()
        Log.d(MY_LOG_TAG, "onDestroy")
        articleListPresenter.detachView()
        mainArticleListPresenter.detachView()
    }

    private fun initPresenter() {
        initArticlePresenter()
        initMainArticlePresenter()
    }

    private fun initArticlePresenter() {
        val viewModel = ViewModelProvider(this)
            .get(ArticleListPresenterImpl.ArticleListViewModel::class.java)
        viewModel.articleListViewModel?.let {
            articleListPresenter = it
            return
        }
        val service: Api
        activity?.let {
            service = (it.application as App).getDependencyRoot().service
            articleListPresenter = ArticleListPresenterImpl(service)
            viewModel.articleListViewModel = articleListPresenter
        }
    }

    private fun initMainArticlePresenter() {
        val viewModel = ViewModelProvider(this)
            .get(MainArticleListPresenterImpl.MainArticleListViewModel::class.java)
        viewModel.mainArticleListPresenter?.let {
            mainArticleListPresenter = it
            return
        }
        val service: Api
        activity?.let {
            service = (it.application as App).getDependencyRoot().service
            mainArticleListPresenter = MainArticleListPresenterImpl(service)
            viewModel.mainArticleListPresenter = mainArticleListPresenter
        }
    }

    private fun initViews(view: View) {
        mainArticleListView = MainArticleListViewImpl(
            this,
            view.findViewById(R.id.fragment_article_list__include_main_recycler)
        )
        articleListView = ArticleListViewImpl(
            this,
            view.findViewById(R.id.fragment_article_list__include_article_recycle)
        )
    }

    private fun attachArticleListView(articleListView: ArticleListView) {
        articleListPresenter.attachView(articleListView)
    }

    private fun attachMainArticleListView(mainArticleListView: ArticleListView) {
        mainArticleListPresenter.attachView(mainArticleListView)
    }

    private fun observePresentersLiveData() {
        observeArticleListPresenterLiveData()
        observeMainArticleListPresenterLiveData()
    }

    private fun observeArticleListPresenterLiveData() {
        articleListPresenter.getLiveData().observe(
            viewLifecycleOwner,
            Observer { articles ->
                articleListView.bindData(articles)
            }
        )
        articleListPresenter.bindArticleListView()
    }

    private fun observeMainArticleListPresenterLiveData() {
        mainArticleListPresenter.getLiveData().observe(
            viewLifecycleOwner,
            Observer { mainArticles ->
                mainArticleListView.bindData(mainArticles)
            }
        )
        mainArticleListPresenter.bindArticleListView()
    }

    override fun onMainAdapterItemClick() {
        parentFragmentManager.beginTransaction()
            .replace(
                R.id.activity_main__container,
                DetailArticleFragment(),
                DETAIL_ARTICLE_FRAGMENT
            )
            .addToBackStack(null)
            .commit()
    }

    override fun onAdapterItemClick() {
        parentFragmentManager.beginTransaction()
            .replace(
                R.id.activity_main__container,
                DetailArticleFragment(),
                DETAIL_ARTICLE_FRAGMENT
            )
            .addToBackStack(null)
            .commit()
    }
}