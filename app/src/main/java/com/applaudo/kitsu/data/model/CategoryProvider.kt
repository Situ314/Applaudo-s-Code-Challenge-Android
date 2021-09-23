package com.applaudo.kitsu.data.model

import javax.inject.Inject
import javax.inject.Singleton

@Singleton
class CategoryProvider @Inject constructor() {
         var category_response:CategoriesResponse? = null
}