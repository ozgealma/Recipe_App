package com.example.recipeapp.repository

import com.example.recipeapp.model.CRUD
import com.example.recipeapp.model.Recipe
import retrofit2.Response

interface RecipeRepository {

    suspend fun getAllRecipe(): Response<Recipe>

    suspend fun getRecipeDetail(): Response<Recipe>

    suspend fun searchRecipe(query: String): Response<CRUD>

    suspend fun addRecipe(
        recipe_name: String,
        recipe_content: String): Response<CRUD>


    suspend fun updateRecipe(
        updateRecipeRequest: Int,
        recipe_name: String,
        recipe_content: String
    ): Response<CRUD>


}