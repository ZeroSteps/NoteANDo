package ru.exemple.noteando.ui.baseView

import android.view.View

abstract class BaseView(private val rootView: View) {

    protected fun getRootView(): View {
        return rootView
    }
}