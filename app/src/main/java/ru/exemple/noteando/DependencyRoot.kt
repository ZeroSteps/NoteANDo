package ru.exemple.noteando

import android.content.Context
import ru.exemple.noteando.api.Api
import ru.exemple.noteando.api.ApiImpl
import ru.exemple.noteando.api.ApiStubImpl

class DependencyRoot(context: Context) {
//    val apiImpl: Api = ApiImpl()
    val apiStubImpl: Api = ApiStubImpl()
}