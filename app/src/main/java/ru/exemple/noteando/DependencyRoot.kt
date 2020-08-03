package ru.exemple.noteando

import android.content.Context
import ru.exemple.noteando.network.Service
import ru.exemple.noteando.network.api.Api
import ru.exemple.noteando.network.api.ApiStubImpl

class DependencyRoot(context: Context) {
//    val service: Api = ApiImpl()
//    val service: Api = ApiStubImpl()
    val service: Api = Service()
}