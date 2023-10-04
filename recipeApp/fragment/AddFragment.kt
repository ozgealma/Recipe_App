package com.example.recipeapp.fragment

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.example.recipeapp.databinding.FragmentAddBinding
import com.example.recipeapp.viewmodel.AddViewModel
import kotlinx.coroutines.runBlocking

class AddFragment : Fragment() {
    private var _binding : FragmentAddBinding? = null
    private val binding get() =_binding!!
    private lateinit var viewModel: AddViewModel

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        // Inflate the layout for this fragment
        _binding = FragmentAddBinding.inflate(layoutInflater,container,false)
        val view = binding.root
        return view

    }
    fun buttonSave(recipe_name:String, recipe_content:String){
        runBlocking {
            viewModel.add(recipe_name,recipe_content)
            println("savebutton")
        }
    }

}