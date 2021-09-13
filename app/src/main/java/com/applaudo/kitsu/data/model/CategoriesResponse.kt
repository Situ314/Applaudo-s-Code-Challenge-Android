package com.applaudo.kitsu.data.model

import com.google.gson.annotations.SerializedName

class CategoriesResponse (

    @SerializedName("data") var data : List<Category>,
    @SerializedName("included") var anime : List<Anime>,
    @SerializedName("meta") var meta : Meta,
    @SerializedName("links") var links : Links

)