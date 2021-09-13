package com.applaudo.kitsu.data.model

import android.os.Parcelable
import com.google.gson.annotations.SerializedName
import kotlinx.android.parcel.Parcelize

@Parcelize
data class Anime (

    @SerializedName("id") var id : String,
    @SerializedName("type") var type : String,
    @SerializedName("attributes") var attributes : AttributesAnime,
//    @SerializedName("relationships") var relationships : RelationshipsAnime

) : Parcelable