package com.example.recipeapp.viewmodel

import androidx.lifecycle.ViewModel
import com.example.recipeapp.repository.RecipeRepository
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject


class AddViewModel (private var rrepo : RecipeRepository): ViewModel() {
    suspend fun add(recipe_name:String, recipe_content:String){
        rrepo.addRecipe(recipe_name,recipe_content)
    }

}