package com.example.recipeapp.di

import com.example.recipeapp.repository.RecipeRepository
import com.example.recipeapp.repository.RecipeRepositoryMain
import dagger.Binds
import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
interface RepositoryBinding {

    @Binds
    @Singleton
    fun bindRecipeRepository(repository: RecipeRepositoryMain): RecipeRepository
}