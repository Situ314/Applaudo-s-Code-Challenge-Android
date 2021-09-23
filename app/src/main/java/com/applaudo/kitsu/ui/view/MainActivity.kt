package com.applaudo.kitsu.ui.view

import android.content.Context
import android.graphics.Color
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.view.View
import android.view.inputmethod.InputMethodManager
import android.widget.TextView
import androidx.activity.viewModels
import androidx.appcompat.widget.SearchView
import androidx.core.view.isVisible
import androidx.lifecycle.Observer
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.swiperefreshlayout.widget.SwipeRefreshLayout
import com.applaudo.kitsu.data.model.Anime
import com.applaudo.kitsu.data.model.Category
import com.applaudo.kitsu.databinding.ActivityMainBinding
import com.applaudo.kitsu.ui.viewmodel.CategoryViewModel
import com.google.android.material.snackbar.Snackbar
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding

    lateinit var categoryAdapter: CategoryAdapter

    private val categoryViewModel: CategoryViewModel by viewModels()

    lateinit var swipeContainer: SwipeRefreshLayout

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        categoryViewModel.onCreate()

        binding.swipeContainer.setOnRefreshListener {
            binding.swipeContainer.isRefreshing = false
            categoryViewModel.onCreate()
        }

        categoryViewModel.categoryModel.observe(this, Observer {
            setAdapterCategory(it!!.data.toMutableList(), it.anime, applicationContext)

            binding.search.setOnQueryTextListener(object : SearchView.OnQueryTextListener {
                override fun onQueryTextSubmit(query: String): Boolean {
                    if(query != " "){
                        categoryAdapter.clear()
                        val animeFiltered = mutableListOf<Anime>()
                        val categoryFiltered = mutableListOf<Category>()

                        for(category in it.data){
                            for(anime in it.anime){
                                if(anime.attributes.canonicalTitle.toLowerCase().startsWith(query.toLowerCase()) && category.relationships.anime_category.anime_data.filter { it.id == anime.id }.isNotEmpty()){
                                    animeFiltered.add(anime)
                                    if (category !in categoryFiltered)
                                        categoryFiltered.add(category)
                                }
                            }
                        }

                        if(!categoryFiltered.isEmpty()){
                            setAdapterCategory(categoryFiltered,animeFiltered, applicationContext)
                        }else{
                            val snackbar = Snackbar.make(binding.root, "Animes not found, please try again with another word",
                                Snackbar.LENGTH_LONG).setAction("Action", null)
                            val snackbarView = snackbar.view
                            snackbarView.setBackgroundColor(Color.RED)
                            snackbar.show()
                        }
                    }else{
                        setAdapterCategory(it.data.toMutableList(), it.anime, applicationContext)
                    }

                    hideKeyboard()

                    return false
                }
                override fun onQueryTextChange(newText: String): Boolean {
                    return false
                }
            })
        })

        categoryViewModel.isLoading.observe(this, Observer {
            binding.loading.isVisible = it
        })

        categoryViewModel.isFailing.observe(this, Observer {
            binding.lyError.isVisible = it
        })

    }

    private fun hideKeyboard(){
        val imm = getSystemService(INPUT_METHOD_SERVICE) as InputMethodManager
        imm.hideSoftInputFromWindow(binding.root.windowToken, 0)
    }

    private fun setAdapterCategory(categoriesList: MutableList<Category>, animeList: List<Anime>, context: Context){
        categoryAdapter = CategoryAdapter(categoriesList, animeList, context)
        binding.rvCategories.setHasFixedSize(true)
        binding.rvCategories.layoutManager = LinearLayoutManager(applicationContext)
        binding.rvCategories.adapter = categoryAdapter
    }
}