package com.applaudo.kitsu.data

import com.applaudo.kitsu.data.model.AnimeProvider
import com.applaudo.kitsu.data.model.AnimesResponse
import com.applaudo.kitsu.data.model.CategoriesResponse
import com.applaudo.kitsu.data.model.CategoryProvider
import com.applaudo.kitsu.data.network.CategoryService

class AnimeRepository {
    private val api = CategoryService()
    suspend fun getAnimes(title: String): AnimesResponse?{
        val response = api.getAnimes(title)
        AnimeProvider.anime_response = response
        return response
    }
}