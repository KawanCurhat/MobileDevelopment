@file:OptIn(ExperimentalMaterial3Api::class, ExperimentalMaterial3Api::class,
    ExperimentalMaterial3Api::class
)

package com.kc.kawancurhat.presentation.article

import android.content.ContentValues.TAG
import android.content.Context
import android.util.Log
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.automirrored.filled.ArrowBack
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.material3.TopAppBarDefaults
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.MutableState
import androidx.compose.runtime.mutableStateOf
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext
import com.kc.kawancurhat.data.model.Article
import com.kc.kawancurhat.data.response.ArticleResponse
import com.kc.kawancurhat.data.retrofit.ApiConfig
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

var listArticles = mutableStateOf(listOf<Article>())

fun getArticle() {
    val client = ApiConfig.getApiService().getArticle()
    client.enqueue(object : Callback<ArticleResponse> {
        override fun onResponse(call: Call<ArticleResponse>, response: Response<ArticleResponse>) {
            if (response.isSuccessful) {
                val responseBody = response.body()
                if (responseBody != null) {
                    val articles = responseBody.articles
//                    listArticles.value = articles?.toList()
                }
            } else {
                Log.e(TAG, "onFailure: ${response.message()}")
            }
        }

        override fun onFailure(call: Call<ArticleResponse>, t: Throwable) {
            Log.e(TAG, "onFailure: ${t.message}")
        }

    })
}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun ArticlePage(
    onBackPressed: () -> Unit,
) {
    val context = LocalContext.current

    LaunchedEffect(Unit) {
        getArticle()
    }

    Scaffold(
        topBar = {
            TopAppBar(
                title = {
                    Text("Article")
                },
                navigationIcon = {
                    IconButton(onClick = { onBackPressed() }) {
                        Icon(Icons.AutoMirrored.Filled.ArrowBack, "Back Icon")
                    }
                },
                colors = TopAppBarDefaults.topAppBarColors(
                    containerColor = MaterialTheme.colorScheme.primary,
                    titleContentColor = Color.White
                ),
            )
        }, content = {
            LazyColumn(
                contentPadding = it
            ) {
                items(listArticles.value) { article ->
                    ArticleItem(
                        imgUrl = article.imgUrl,
                        title = article.title,
                        desc = article.description
                    )
                }
            }
        }
    )
}