package ru.exemple.noteando.ui.articleList

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.HorizontalScrollView
import android.widget.ImageView
import android.widget.LinearLayout
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
//        private val ivArticleBackground: ImageView =
//            view.findViewById(R.id.item_article__ivArticleBackground)

        fun bind(articles: List<Article>, listener: OnAdapterItemClickListener) {
            tvTitle.text = articles[adapterPosition].title
            tvDescription.text = articles[adapterPosition].description
//            setIvArticleBackgroundOutline(ivArticleBackground)
            for (category in articles[adapterPosition].array) {
                llCategory.addView(
                    CustomLayout(
                        itemView.context,
                        category
                    )
                )
            }
            itemView.setOnClickListener { listener.onAdapterItemClick() }
        }

        private fun setIvArticleBackgroundOutline(view: ImageView) {
//        TODO: change API version to Lollipop
//        val outlineProvider = object : ViewOutlineProvider() {
//            override fun getOutline(view: View?, outline: Outline?) {
//                val path = Path()
//                path.moveTo(0f, 0f)
//                path.rLineTo(44f, 108f)
//                path.rLineTo(143f, 108f)
//                path.rLineTo(143f, 0f)
//                path.rLineTo(0f, 0f)
//
//                outline?.setConvexPath(path)
//            }
//        }
//        view.outlineProvider = outlineProvider
//        view.clipToOutline = true


//        val image = view
//        val curveRadius = 20F
//
//        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP) {
//
//            image.outlineProvider = object : ViewOutlineProvider() {
//
//                @RequiresApi(Build.VERSION_CODES.LOLLIPOP)
//                override fun getOutline(view: View?, outline: Outline?) {
//                    outline?.setRoundRect(
//                        0,
//                        0,
//                        view!!.width,
//                        (view.height + curveRadius).toInt(),
//                        curveRadius
//                    )
//                }
//            }
//            image.clipToOutline = true
//        }
        }
    }

    interface OnAdapterItemClickListener {
        fun onAdapterItemClick()
    }
}