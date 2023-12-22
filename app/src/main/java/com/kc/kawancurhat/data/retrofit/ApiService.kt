package com.kc.kawancurhat.data.retrofit

import com.kc.kawancurhat.data.response.ArticleResponse
import retrofit2.Call
import retrofit2.http.GET

interface ApiService {
    @GET("v2/top-headlines?apiKey=76af91d2ed2340228e51d4777d5b697d&category=health&country=id")
    fun getArticle(): Call<ArticleResponse>
}