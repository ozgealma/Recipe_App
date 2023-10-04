package com.example.recipeapp.model

import java.io.Serializable

data class Recipe(var id:Int,
                  var name:String,
                  var description: String): Serializable {
}