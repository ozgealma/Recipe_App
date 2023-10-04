package com.example.recipeapp.di


import com.example.recipeapp.repository.RecipeRepository
import com.example.recipeapp.repository.RecipeRepositoryMain
import com.example.recipeapp.retrofit.ApiUtils
import com.example.recipeapp.retrofit.RecipeDao
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object AppModule {
    @Provides
    @Singleton
    fun provideRecipeRepository(kdao: RecipeDao) : RecipeRepository {
        return RecipeRepositoryMain(kdao)
    }
  /*  @Provides
    @Singleton
    fun provideRecipeRepository(
        recipeDao: RecipeDao
    ): RecipeRepository {
        return RecipeRepositoryMain(recipeDao)
    }*/

    @Provides
    @Singleton
    fun provideRecipeDao() : RecipeDao {
        return ApiUtils.getRecipeDao()
    }
}