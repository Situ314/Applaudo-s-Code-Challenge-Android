package com.applaudo.kitsu.data

import com.applaudo.kitsu.data.model.CategoriesResponse
import com.applaudo.kitsu.data.model.CategoryProvider
import com.applaudo.kitsu.data.network.CategoryService
import javax.inject.Inject

class CategoryRepository @Inject constructor(private val api : CategoryService, private val categoryProvider: CategoryProvider) {

    suspend fun getCategories():CategoriesResponse?{
        val response = api.getCategories()
        categoryProvider.category_response = response
        return response
    }
}