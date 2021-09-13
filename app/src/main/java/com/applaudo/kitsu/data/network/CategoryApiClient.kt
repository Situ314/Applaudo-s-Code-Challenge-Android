package com.applaudo.kitsu.data.network

import com.applaudo.kitsu.data.model.AnimesResponse
import com.applaudo.kitsu.data.model.CategoriesResponse
import retrofit2.Response
import retrofit2.http.Field
import retrofit2.http.FormUrlEncoded
import retrofit2.http.GET
import retrofit2.http.Query

interface CategoryApiClient {
    @GET("api/edge/categories")
    suspend fun getCategories(
        @Query("include") field: String,
        @Query("fields[anime]") anime: String,
    ): Response<CategoriesResponse?>

    @GET("api/edge/anime")
    suspend fun getAnimes(
        @Query("filter[categories]") filter: String,
        @Query("fields[anime]") fields: String,
    ): Response<AnimesResponse?>
}