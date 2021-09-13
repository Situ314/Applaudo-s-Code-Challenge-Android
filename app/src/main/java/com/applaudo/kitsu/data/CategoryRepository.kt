package com.applaudo.kitsu.data

import com.applaudo.kitsu.data.model.CategoriesResponse
import com.applaudo.kitsu.data.model.CategoryProvider
import com.applaudo.kitsu.data.network.CategoryService

class CategoryRepository {
    private val api = CategoryService()
    suspend fun getCategories():CategoriesResponse?{
        val response = api.getCategories()
        CategoryProvider.category_response = response
        return response
    }
}