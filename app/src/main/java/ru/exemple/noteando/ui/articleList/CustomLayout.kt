package ru.exemple.noteando.ui.articleList

import android.content.Context
import android.graphics.Outline
import android.os.Build
import android.view.View
import android.view.ViewOutlineProvider
import android.widget.ImageView
import android.widget.LinearLayout
import android.widget.TextView
import androidx.annotation.RequiresApi
import androidx.appcompat.content.res.AppCompatResources.getDrawable
import ru.exemple.noteando.R

class CustomLayout(context: Context, category: String) : LinearLayout(context) {
    init {
        val view = inflate(context, R.layout.custom_layout_category, this)
        setLayoutRoundRectCorners(view)
        val ivCategory: ImageView = findViewById(R.id.custom_layout_category__ivCategory)
        val tvCategory: TextView = findViewById(R.id.custom_layout_category__tvCategory)
        ivCategory.setImageDrawable(getDrawable(context, R.drawable.ic_baseline_computer_24))
        tvCategory.text = category
    }

    private fun setLayoutRoundRectCorners(view: View) {
        val curveRadius = 20F

        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP) {

            view.outlineProvider = object : ViewOutlineProvider() {
                override fun getOutline(view: View?, outline: Outline?) {
                    outline?.setRoundRect(
                        0,
                        0,
                        view!!.width,
                        view.height,
                        curveRadius
                    )
                }
            }
            view.clipToOutline = true
        }
    }
}