package ru.exemple.noteando.ui

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import ru.exemple.noteando.ARTICLE_LIST_FRAGMENT
import ru.exemple.noteando.MY_LOG_TAG
import ru.exemple.noteando.R
import ru.exemple.noteando.ui.articleList.ArticleListFragment

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        if (savedInstanceState == null) {
            Log.d(MY_LOG_TAG, "savedInstanceState == null")
            supportFragmentManager.beginTransaction()
                .add(R.id.activity_main__container, ArticleListFragment(), ARTICLE_LIST_FRAGMENT)
                .commit()
        }
    }
}