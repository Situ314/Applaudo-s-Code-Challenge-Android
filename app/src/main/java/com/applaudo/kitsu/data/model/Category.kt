package com.applaudo.kitsu.data.model

import com.google.gson.annotations.SerializedName

data class Category (

    @SerializedName("id") var id : String,
    @SerializedName("type") var type : String,
    @SerializedName("links") var links : Links,
    @SerializedName("attributes") var attributes : Attributes,
    @SerializedName("relationships") var relationships : Relationships
)