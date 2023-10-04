package com.example.recipeapp.retrofit

import com.example.recipeapp.data.entity.Recipe
import com.example.recipeapp.data.entity.RecipeCevap
import retrofit2.Response
import retrofit2.http.GET

interface RecipeDao {

    //https://api.canerture.com/recipes/get_recipes.php
    //https://api.canerture.com/ -> base url
    //recipes/get_recipes.php -> webservis url

 /*   @GET("get_recipes.php")
    suspend fun getReceipts(): Response<Recipe?>*/
    @GET("get_recipes.php")
    suspend fun recipeYukle(): Response<RecipeCevap>


}