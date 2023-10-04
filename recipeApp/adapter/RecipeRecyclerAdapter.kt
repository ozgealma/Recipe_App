package com.example.recipeapp.adapter

import android.content.Context
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.recyclerview.widget.RecyclerView
import com.example.recipeapp.R
import com.example.recipeapp.databinding.RecipeRecyclerRowBinding
import com.example.recipeapp.model.CRUD
import com.example.recipeapp.model.Recipe
class RecipeRecyclerAdapter(val recipetList : ArrayList<Recipe>):RecyclerView.Adapter<RecipeRecyclerAdapter.RecipeViewHolder>() {

    //private val recipetList = ArrayList<Recipe>()
    val mContext : Context? = null

     class RecipeViewHolder(val binding: RecipeRecyclerRowBinding) : RecyclerView.ViewHolder(binding.root){

    }


    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RecipeViewHolder {
        val layoutInflater = LayoutInflater.from(mContext)
        val binding: RecipeRecyclerRowBinding = DataBindingUtil.inflate(layoutInflater,
            R.layout.recipe_recycler_row,parent,false)
        return RecipeViewHolder(binding)
    }

    override fun getItemCount(): Int {
        return recipetList.size
    }

    override fun onBindViewHolder(holder: RecipeViewHolder, position: Int) {
        val recipe = recipetList.get(position)
        val t = holder.binding



/*
        t.satirCard.setOnClickListener {
            val gecis = RecipeListFragmentDirections.actionRecipeListFragmentToRecipeDetailFragment(recipe = recipe)//(recipe = recipe)= nav_graph.xml deki arguments kısmında recipe parametresini eklememiz lazım.
            Navigation.gecisYap(it,gecis)
        }*/
        /*
            t.imageViewDelete.setOnClickListener {
                Snackbar.make(it,"${recipe.recipe_name} silinsin mi?",Snackbar.LENGTH_LONG)
                    .setAction("EVET"){
                        viewModel.delete(recipe.recipe_id)
                    }.show()
            }

         */

    }

}