package ru.exemple.noteando

import android.content.Context
import ru.exemple.noteando.network.Service
import ru.exemple.noteando.network.api.Api
import ru.exemple.noteando.network.api.ApiStubImpl
import ru.exemple.noteando.network.api.RetrofitApi

class DependencyRoot(context: Context) {
    //    val service: Api = ApiImpl()
    val service: Api = ApiStubImpl()
//    private val retrofitApi = RetrofitApi.create()
//    val service: Api = Service(retrofitApi)
}