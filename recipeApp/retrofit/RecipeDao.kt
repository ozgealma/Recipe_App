package com.example.recipeapp.retrofit

import com.example.recipeapp.model.CRUD
import com.example.recipeapp.model.Recipe
import retrofit2.Response
import retrofit2.http.Body
import retrofit2.http.GET
import retrofit2.http.POST
import retrofit2.http.Query

interface RecipeDao {
    //https://api.canerture.com/recipes/get_recipes.php
    @GET("get_recipes.php")
    suspend fun getAllRecipeData() : Response<Recipe>

    @GET("get_recipe_detail.php")
    suspend fun getRecipeDetailData(): Response<Recipe>

    //mercimeği arıyor daha sonra düzelt !!!!!!!!!!!!!!!!
    //https://api.canerture.com/recipes/search_recipe.php?query=mercimek
    @POST("search_recipe.php")
    suspend fun searchRecipeData(@Query("name") recipe_name: String): Response<CRUD>


    //https://api.canerture.com/recipes/add_recipe.php?=
    @POST("add_recipe.php")
    fun addRecipeData(@Body addRecipe: String, recipe_content: String): Response<CRUD>


    //https://api.canerture.com/recipes/update_recipe.php
    @POST("update_recipe.php")
    suspend fun updateRecipeData(
        @Body updateRecipe: Int,
        recipe_name: String,
        recipe_content: String
    ): Response<CRUD>







}