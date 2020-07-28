package ru.exemple.noteando.ui.articleList

import android.view.View
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import ru.exemple.noteando.R
import ru.exemple.noteando.article.Article
import ru.exemple.noteando.ui.baseView.BaseView

class ArticleListViewImpl(rootView: View) : BaseView(rootView), ArticleListView {

    init {
        init()
    }

    private lateinit var adapter: ArticleListAdapter

    private fun init() {
        adapter = ArticleListAdapter()
        val linearLayoutManager =
            LinearLayoutManager(getRootView().context, RecyclerView.VERTICAL, false)
        val recyclerView: RecyclerView =
            getRootView().findViewById(R.id.fragment_article_list__rvArticles)
        recyclerView.adapter = adapter
        recyclerView.layoutManager = linearLayoutManager
    }

    override fun showLoading() {

    }

    override fun hideLoading() {

    }

    override fun bindData(articles: List<Article>) {
        adapter.notifyRefreshData(articles)
    }
}