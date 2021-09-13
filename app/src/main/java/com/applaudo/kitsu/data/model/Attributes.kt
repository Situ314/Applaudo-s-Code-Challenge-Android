package com.applaudo.kitsu.data.model

import com.google.gson.annotations.SerializedName

data class Attributes (

    @SerializedName("createdAt") var createdAt : String,
    @SerializedName("updatedAt") var updatedAt : String,
    @SerializedName("title") var title : String,
    @SerializedName("description") var description : String,
    @SerializedName("totalMediaCount") var totalMediaCount : Int,
    @SerializedName("slug") var slug : String,
    @SerializedName("nsfw") var nsfw : Boolean,
    @SerializedName("childCount") var childCount : Int,

)