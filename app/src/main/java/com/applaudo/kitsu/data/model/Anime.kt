package com.applaudo.kitsu.data.model

import com.google.gson.annotations.SerializedName

data class Anime (

    @SerializedName("id") var id : String,
    @SerializedName("type") var type : String,
    @SerializedName("links") var links : Links,
    @SerializedName("attributes") var attributes : AttributesAnime,
    @SerializedName("relationships") var relationships : RelationshipsAnime

)