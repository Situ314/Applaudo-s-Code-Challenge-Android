package com.applaudo.kitsu.data.model

import android.os.Parcelable
import com.google.gson.annotations.SerializedName
import kotlinx.android.parcel.Parcelize

@Parcelize
data class RelationshipsAnime (

    @SerializedName("genres") var genres : Genres

) : Parcelable