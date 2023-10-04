package com.example.recipeapp.repository

import androidx.lifecycle.MutableLiveData
import com.example.recipeapp.retrofit.RecipeDao
import com.example.recipeapp.model.CRUD
import com.example.recipeapp.model.Recipe
import retrofit2.Response
import javax.inject.Inject

class RecipeRepositoryMain @Inject constructor(private val recipeAPI : RecipeDao
) :
    RecipeRepository {

    var recipeList: MutableLiveData<List<Recipe>?>

    init {
        recipeList = MutableLiveData()
    }

    override suspend fun getAllRecipe(): Response<Recipe> = recipeAPI.getAllRecipeData()

    override suspend fun getRecipeDetail(): Response<Recipe> = recipeAPI.getRecipeDetailData()

    override suspend fun searchRecipe(query: String): Response<CRUD> =
        recipeAPI.searchRecipeData(query)

    override suspend fun addRecipe(recipe_name: String, recipe_content: String): Response<CRUD> =
        recipeAPI.addRecipeData(recipe_name, recipe_content)

    override suspend fun updateRecipe(
        updateRecipeRequest: Int,
        recipe_name: String,
        recipe_content: String
    ): Response<CRUD> =
        recipeAPI.updateRecipeData(updateRecipeRequest, recipe_name, recipe_content)







    }