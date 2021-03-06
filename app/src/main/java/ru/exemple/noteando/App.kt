package ru.exemple.noteando

import android.app.Application

class App: Application() {

    private lateinit var dependencyRoot: DependencyRoot

    override fun onCreate() {
        super.onCreate()
        dependencyRoot = DependencyRoot(this)
    }

    fun getDependencyRoot(): DependencyRoot {
        return dependencyRoot
    }
}