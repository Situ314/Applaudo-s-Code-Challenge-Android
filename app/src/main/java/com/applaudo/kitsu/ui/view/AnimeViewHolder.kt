package com.applaudo.kitsu.ui.view

import android.util.Log
import android.view.View
import androidx.activity.viewModels
import androidx.recyclerview.widget.RecyclerView
import com.applaudo.kitsu.data.model.Anime
import com.applaudo.kitsu.data.model.Category
import com.applaudo.kitsu.databinding.AnimeItemBinding
import com.applaudo.kitsu.databinding.CategoryItemBinding
import com.applaudo.kitsu.ui.viewmodel.CategoryViewModel
import com.squareup.picasso.Picasso

class AnimeViewHolder(view: View): RecyclerView.ViewHolder(view) {
    private val binding = AnimeItemBinding.bind(view)

    fun bind(anime: Anime){
        Log.e("CHECK ANIME HHOLDER ", anime.attributes.canonicalTitle)
        binding.tvAnimeTitle.text = anime.attributes.canonicalTitle
        Picasso.get().load(anime.attributes.posterImage.medium).into(binding.ivAnime)
    }
}