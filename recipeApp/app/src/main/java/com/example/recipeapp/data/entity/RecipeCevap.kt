package com.example.recipeapp.data.entity

data class RecipeCevap(
    val message: String,
    val recipes: List<Recipe>,
    val status: Int
)