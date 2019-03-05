package com.jejun.album

import com.jakewharton.retrofit2.adapter.kotlin.coroutines.CoroutineCallAdapterFactory
import retrofit2.Retrofit

fun formatMessage(name: String): String = "Hello, $name"

val retrofit = Retrofit.Builder()
        .baseUrl("https://example.com/")
        .addCallAdapterFactory(CoroutineCallAdapterFactory())
        .build()
