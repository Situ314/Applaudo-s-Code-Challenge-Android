package com.applaudo.kitsu.ui.view

import android.content.Context
import android.util.Log
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.applaudo.kitsu.R
import com.applaudo.kitsu.data.model.Anime
import com.applaudo.kitsu.data.model.Category

class AnimeAdapter(private val animes: List<Anime>, private val context: Context) : RecyclerView.Adapter<AnimeViewHolder>() {
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): AnimeViewHolder {
        val layoutInflater = LayoutInflater.from(parent.context)
        return AnimeViewHolder(layoutInflater.inflate(R.layout.anime_item, parent, false))
    }

    override fun onBindViewHolder(holder: AnimeViewHolder, position: Int) {
        val item = animes[position]
        Log.e("CHECK ANIME HHOLDER ", item.attributes.canonicalTitle)
        holder.bind(item,context)
    }

    override fun getItemCount(): Int {
        return animes.size
    }
}