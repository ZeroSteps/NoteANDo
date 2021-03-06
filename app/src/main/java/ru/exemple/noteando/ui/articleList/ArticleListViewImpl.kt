package ru.exemple.noteando.ui.articleList

import android.view.View
import android.widget.ProgressBar
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import ru.exemple.noteando.R
import ru.exemple.noteando.article.Article
import ru.exemple.noteando.ui.baseView.BaseView

class ArticleListViewImpl(private val listener: OnAdapterItemClickListener, rootView: View) : BaseView(rootView), ArticleListView,
    ArticleListAdapter.OnAdapterItemClickListener {

    private lateinit var adapter: ArticleListAdapter

    private lateinit var pbLoading: ProgressBar

    init {
        init()
    }

    private fun init() {
        adapter = ArticleListAdapter(this)
        val linearLayoutManager =
            LinearLayoutManager(getRootView().context, RecyclerView.VERTICAL, false)
        val recyclerView: RecyclerView =
            getRootView().findViewById(R.id.view_recycler__rvArticles)
        pbLoading = getRootView().findViewById(R.id.view_recycler__pbLoading)
        recyclerView.adapter = adapter
        recyclerView.layoutManager = linearLayoutManager
    }

    override fun bindData(articles: List<Article>) {
        adapter.notifyRefreshData(articles)
        hideLoading()
    }

    override fun showLoading() {
        pbLoading.visibility = View.VISIBLE
    }

    override fun hideLoading() {
        pbLoading.visibility = View.GONE
    }

    override fun onAdapterItemClick() {
        listener.onAdapterItemClick()
    }

    interface OnAdapterItemClickListener {
        fun onAdapterItemClick()
    }
}