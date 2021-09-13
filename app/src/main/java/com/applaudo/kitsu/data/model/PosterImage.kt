package com.applaudo.kitsu.data.model

import android.os.Parcelable
import com.google.gson.annotations.SerializedName
import kotlinx.android.parcel.Parcelize

@Parcelize
data class PosterImage (

    @SerializedName("tiny") var tiny : String,
    @SerializedName("small") var small : String,
    @SerializedName("medium") var medium : String,
    @SerializedName("large") var large : String,
    @SerializedName("original") var original : String,

) : Parcelable