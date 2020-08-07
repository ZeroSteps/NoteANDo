package ru.exemple.noteando.ui.articleList

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import ru.exemple.noteando.R
import ru.exemple.noteando.article.Article

class MainArticleListAdapter(private val listener: OnAdapterItemClickListener) :
    RecyclerView.Adapter<MainArticleListAdapter.ViewHolder>() {

    private val mainArticles = ArrayList<Article>()

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val view = LayoutInflater.from(parent.context)
            .inflate(R.layout.item_main_article, parent, false)
        return ViewHolder(view)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.tvTitle.text = mainArticles[position].title
        holder.itemView.setOnClickListener { listener.onAdapterItemClick() }
    }

    override fun getItemCount(): Int {
        return mainArticles.size
    }

    fun notifyRefreshData(articles: List<Article>) {
        this.mainArticles.clear()
        this.mainArticles.addAll(articles)
        notifyDataSetChanged()
    }

    class ViewHolder(view: View) : RecyclerView.ViewHolder(view) {
        val tvTitle: TextView = view.findViewById(R.id.item_article__tvTitle)
    }

    interface OnAdapterItemClickListener {
        fun onAdapterItemClick()
    }
}
