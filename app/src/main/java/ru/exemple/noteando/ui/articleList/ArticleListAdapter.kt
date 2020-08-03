package ru.exemple.noteando.ui.articleList

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import ru.exemple.noteando.R
import ru.exemple.noteando.article.Article

class ArticleListAdapter(private val listener: OnAdapterItemClickListener) :
    RecyclerView.Adapter<ArticleListAdapter.ViewHolder>() {

    private var articles = ArrayList<Article>()

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val view = LayoutInflater.from(parent.context)
            .inflate(R.layout.item_article, parent, false)
        return ViewHolder(view)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.tvTitle.text = articles[position].title
        holder.tvDescription.text = articles[position].description
        holder.itemView.setOnClickListener { listener.onAdapterItemClick() }
    }

    override fun getItemCount(): Int {
        return articles.size
    }

    fun notifyRefreshData(articles: List<Article>) {
        this.articles.clear()
        this.articles.addAll(articles)
        notifyDataSetChanged()
    }

    class ViewHolder(view: View) : RecyclerView.ViewHolder(view) {
        val tvTitle: TextView = view.findViewById(R.id.item_article__tvTitle)
        val tvDescription: TextView = view.findViewById(R.id.item_article__tvDescription)
    }

    interface OnAdapterItemClickListener {
        fun onAdapterItemClick()
    }
}