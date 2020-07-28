package ru.exemple.noteando.ui

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import ru.exemple.noteando.ARTICLE_LIST_FRAGMENT
import ru.exemple.noteando.R
import ru.exemple.noteando.ui.articleList.ArticleListFragment

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        if (savedInstanceState == null) {
            supportFragmentManager.beginTransaction()
                .add(R.id.activity_main__container, ArticleListFragment(), ARTICLE_LIST_FRAGMENT)
                .commit()
        }
    }
}