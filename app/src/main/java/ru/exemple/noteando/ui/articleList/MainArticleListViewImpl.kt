package ru.exemple.noteando.ui.articleList

import android.view.View
import android.widget.ProgressBar
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import ru.exemple.noteando.R
import ru.exemple.noteando.article.Article
import ru.exemple.noteando.ui.baseView.BaseView

class MainArticleListViewImpl(
    private val listener: OnMainAdapterItemClickListener,
    rootView: View
) : BaseView(rootView), ArticleListView, MainArticleListAdapter.OnAdapterItemClickListener {

    private lateinit var adapter: MainArticleListAdapter

    private lateinit var pbLoading: ProgressBar

    init {
        init()
    }

    private fun init() {
        adapter = MainArticleListAdapter(this)
        val linearLayoutManager =
            LinearLayoutManager(getRootView().context, RecyclerView.HORIZONTAL, false)
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
        listener.onMainAdapterItemClick()
    }

    interface OnMainAdapterItemClickListener {
        fun onMainAdapterItemClick()
    }
}