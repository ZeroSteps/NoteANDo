package ru.exemple.noteando.ui.articleList

import android.os.Build
import android.util.DisplayMetrics
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.LinearLayout
import android.widget.TextView
import androidx.annotation.RequiresApi
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

    @RequiresApi(Build.VERSION_CODES.JELLY_BEAN_MR1)
    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.bind(articles, listener)
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
        private val tvTitle: TextView = view.findViewById(R.id.item_article__tvTitle)
        private val tvDescription: TextView = view.findViewById(R.id.item_article__tvDescription)
        private val llCategory: LinearLayout =
            view.findViewById(R.id.item_article__llCategories)

        fun bind(articles: List<Article>, listener: OnAdapterItemClickListener) {
            tvTitle.text = articles[adapterPosition].title
            tvDescription.text = articles[adapterPosition].description
            addCustomViewsInLayout(articles)
            itemView.setOnClickListener { listener.onAdapterItemClick() }
        }

        private fun addCustomViewsInLayout(articles: List<Article>) {
            val leftMarginParams: LinearLayout.LayoutParams = LinearLayout.LayoutParams(
                LinearLayout.LayoutParams.WRAP_CONTENT, LinearLayout.LayoutParams.WRAP_CONTENT
            )
            val pixels = convertDpToPixel(8f)
            leftMarginParams.leftMargin = pixels.toInt()
            for (x in articles[adapterPosition].categories.indices) {
                val category = articles[adapterPosition].categories[x]
                if (x == 0) {
                    llCategory.addView(
                        CustomLayout(
                            itemView.context,
                            category
                        )
                    )
                    continue
                }
                llCategory.addView(
                    CustomLayout(
                        itemView.context,
                        category
                    ),
                    leftMarginParams
                )
            }
        }

        private fun convertDpToPixel(dp: Float): Float {
            return dp * (itemView.resources.displayMetrics.densityDpi.toFloat() / DisplayMetrics.DENSITY_DEFAULT)
        }
    }

    interface OnAdapterItemClickListener {
        fun onAdapterItemClick()
    }
}