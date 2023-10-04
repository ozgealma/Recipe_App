package com.example.recipeapp.ui.fragment.anasayfa

import android.util.Log
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.recipeapp.data.entity.Recipe
import com.example.recipeapp.retrofit.RecipeRetrofitClient
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext

class AnaSayfaViewModel(var recipetRetrofitClient: RecipeRetrofitClient) : ViewModel() {

    val receiptList = MutableLiveData<List<Recipe>?>()

    init {
        getReceiptList()
    }

    fun getReceiptList() {
        viewModelScope.launch(Dispatchers.IO) {
            val response = recipetRetrofitClient.retrofit.recipeYukle()
            withContext(Dispatchers.Main) {
                if (response.isSuccessful) {
                    response.body()?.let {recipes ->
                        Log.d("if içi", recipes.toString())
                        receiptList.postValue(recipes.recipes)
                    }
                }else{
                    receiptList.postValue(null)
                }
            }
        }
    }
}