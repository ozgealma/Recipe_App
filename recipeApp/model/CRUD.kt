package com.example.recipeapp.model



data class CRUD(val status:List<Recipe>,
           var message:Int) {
    var recipe: List<Recipe>? = null
}