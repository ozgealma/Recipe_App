package com.example.recipeapp.ui.fragment.recipekayit

import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.example.recipeapp.databinding.FragmentRecipeKayitBinding

class RecipeKayitFragment : Fragment() {
    private lateinit var binding: FragmentRecipeKayitBinding
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?): View? {
        binding = FragmentRecipeKayitBinding.inflate(inflater, container, false)

        binding.toolbarRecipeKayit.title = " Yemek Kayıt"  //toolbar başlık


        binding.buttonKaydet.setOnClickListener {
            val id = binding.editTextYemekId.text.toString()
            val name = binding.editTextYemekAd.text.toString()
            kaydet(id,name)
        }

        return (binding.root)
    }

    fun kaydet(name: String, id: String){
        Log.e("Yemek Kaydet","$id - $name")
    }

}