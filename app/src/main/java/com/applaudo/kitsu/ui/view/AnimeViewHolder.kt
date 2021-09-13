package com.applaudo.kitsu.ui.view

import android.app.Activity
import android.content.Context
import android.content.Intent
import android.util.Log
import android.view.View
import android.widget.Toast
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

    fun bind(anime: Anime, context: Context){

        binding.tvAnimeTitle.text = anime.attributes.canonicalTitle
        Picasso.get().load(anime.attributes.posterImage.medium).into(binding.ivAnime)

        itemView.setOnClickListener(View.OnClickListener {
            val intent = Intent(context, AnimeActivity::class.java)
            intent.putExtra("anime", anime)
            intent.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK)
            context.startActivity(intent)
        })

    }
}