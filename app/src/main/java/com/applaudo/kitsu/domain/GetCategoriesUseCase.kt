package com.applaudo.kitsu.domain

import com.applaudo.kitsu.data.CategoryRepository
import com.applaudo.kitsu.data.model.CategoriesResponse

class GetCategoriesUseCase {
    private val repository = CategoryRepository()
    suspend operator fun invoke():CategoriesResponse? = repository.getCategories()
}