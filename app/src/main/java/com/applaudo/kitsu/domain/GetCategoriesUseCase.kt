package com.applaudo.kitsu.domain

import com.applaudo.kitsu.data.CategoryRepository
import com.applaudo.kitsu.data.model.CategoriesResponse
import javax.inject.Inject

class GetCategoriesUseCase @Inject constructor(private val repository: CategoryRepository) {
    suspend operator fun invoke():CategoriesResponse? = repository.getCategories()
}