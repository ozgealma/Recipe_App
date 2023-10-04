package com.example.recipeapp.viewmodel

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.recipeapp.model.Recipe
import com.example.recipeapp.repository.RecipeRepository
import com.example.recipeapp.retrofit.RecipeDao
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.coroutineScope
import kotlinx.coroutines.runBlocking
import javax.inject.Inject


class RecipeListViewModel(private var rrepo : RecipeRepository) : ViewModel() {
    var recipeList = MutableLiveData<List<Recipe>>()

    init {
        runBlocking {
            coroutineScope {
                loadRecipe()
            }
        }
    }
    suspend fun search(searchWord:String){
        rrepo.searchRecipe(searchWord)
    }
    suspend fun loadRecipe(){
        rrepo.getAllRecipe()
    }

}