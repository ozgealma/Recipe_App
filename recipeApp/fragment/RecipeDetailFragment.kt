package com.example.recipeapp.fragment

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.fragment.navArgs
import com.example.recipeapp.databinding.FragmentRecipeDetailBinding
import com.example.recipeapp.viewmodel.RecipeDetailViewModel

class RecipeDetailFragment : Fragment() {
    private var _binding : FragmentRecipeDetailBinding? = null
    private val binding get() =_binding!!
    private lateinit var viewModel: RecipeDetailViewModel
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        _binding = FragmentRecipeDetailBinding.inflate(layoutInflater,container,false)
        binding.recipeDetailFragment = this
        binding.recipeDetailToolbarName = "Tarif Detay"

        //this fragment is getting data from RecipeListFragment->
        //başka fragmentten gelen veriyi almak ve göstermek için(RecipeListFragment'den)
        val bundle: RecipeDetailFragmentArgs by navArgs()
        val gelenTarif = bundle.recipe
        binding.recipeObject = gelenTarif
        return binding.root
    }

    suspend fun buttonUpdate(recipe_id: Int, recipe_name: String, recipe_content:String) {
        viewModel.update(recipe_id,recipe_name,recipe_content)
    }

}