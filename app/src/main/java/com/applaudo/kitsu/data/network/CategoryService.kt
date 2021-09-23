package com.applaudo.kitsu.data.network

import android.util.Log
import com.applaudo.kitsu.core.RetrofitHelper
import com.applaudo.kitsu.data.model.AnimesResponse
import com.applaudo.kitsu.data.model.CategoriesResponse
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext
import javax.inject.Inject

class CategoryService @Inject constructor(private val api:CategoryApiClient) {

    suspend fun getCategories(): CategoriesResponse? {
        return withContext(Dispatchers.IO) {
            val response = api
                .getCategories("anime","canonicalTitle,synopsis,titles,youtubeVideoId,showType,episodeCount,posterImage,startDate,endDate,genres,slug,ageRatingGuide,averageRating,episodeLength,status","20")
            response.body()
        }
    }
}