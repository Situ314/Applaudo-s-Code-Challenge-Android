package com.applaudo.kitsu.data.network

import android.util.Log
import com.applaudo.kitsu.core.RetrofitHelper
import com.applaudo.kitsu.data.model.AnimesResponse
import com.applaudo.kitsu.data.model.CategoriesResponse
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext

class CategoryService {
    private val retrofit = RetrofitHelper.getRetrofit()
    suspend fun getCategories(): CategoriesResponse? {
        return withContext(Dispatchers.IO) {
            val response = retrofit.create(CategoryApiClient::class.java).getCategories("anime","canonicalTitle,synopsis,titles,youtubeVideoId,showType,episodeCount,posterImage,startDate,endDate,genres,ageRatingGuide,averageRating,episodeLength,status")
            Log.d("corutina", response.body().toString());
            response.body()
        }
    }

    suspend fun getAnimes(category: String): AnimesResponse? {
        return withContext(Dispatchers.IO) {
            val response = retrofit.create(CategoryApiClient::class.java).getAnimes(category, "canonicalTitle,synopsis,titles,youtubeVideoId,showType,episodeCount,posterImage,startDate,endDate,genres,ageRatingGuide,averageRating,episodeLength,status")
            Log.d("corutina anime", response.body().toString());
            response.body()
        }
    }
}