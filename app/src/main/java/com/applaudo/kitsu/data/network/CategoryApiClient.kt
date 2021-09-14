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
        @Query("page[limit]") page: String,
    ): Response<CategoriesResponse?>

}