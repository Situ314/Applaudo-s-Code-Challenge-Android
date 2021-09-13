package com.applaudo.kitsu.ui.view

import android.content.Context
import android.view.View
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.applaudo.kitsu.data.model.Anime
import com.applaudo.kitsu.data.model.Category
import com.applaudo.kitsu.databinding.CategoryItemBinding


class CategoryViewHolder(view: View): RecyclerView.ViewHolder(view) {
    private val binding = CategoryItemBinding.bind(view)
    lateinit var animeAdapter: AnimeAdapter

    fun bind(category: Category, animes: MutableList<Anime>, context: Context){
        binding.tvCategoryTitle.text = category.attributes.title

        animeAdapter = AnimeAdapter(animes, context)
        binding.rvAnimes.setHasFixedSize(true)
        binding.rvAnimes.layoutManager = LinearLayoutManager(context, LinearLayoutManager.HORIZONTAL, false)
        binding.rvAnimes.adapter = animeAdapter
    }
}