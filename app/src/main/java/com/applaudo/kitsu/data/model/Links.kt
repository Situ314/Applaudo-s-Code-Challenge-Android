package com.applaudo.kitsu.data.model

import android.os.Parcelable
import com.google.gson.annotations.SerializedName
import kotlinx.android.parcel.Parcelize

@Parcelize
data class Links (

    @SerializedName("first") var first : String,
    @SerializedName("next") var next : String,
    @SerializedName("last") var last : String

): Parcelable