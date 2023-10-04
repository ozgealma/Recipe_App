package com.example.recipeapp.viewmodel

import androidx.lifecycle.ViewModel
import com.example.recipeapp.repository.RecipeRepository
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject

class RecipeDetailViewModel(private var rrepo : RecipeRepository): ViewModel() {
    suspend fun update(recipe_id:Int, recipe_name:String, recipe_content:String){
        rrepo.updateRecipe(recipe_id,recipe_name,recipe_content)
    }
}