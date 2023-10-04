package com.example.recipeapp.ui.fragment.recipedetay

import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.fragment.navArgs
import com.example.recipeapp.databinding.FragmentRecipeDetayBinding

class RecipeDetayFragment : Fragment() {
    private lateinit var binding: FragmentRecipeDetayBinding
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?): View? {
        binding = FragmentRecipeDetayBinding.inflate(inflater, container, false)

        binding.toolbarRecipeDetay.title = "Yemek Detay"

        val bundle: RecipeDetayFragmentArgs by navArgs()
        val gelenYemek = bundle.yemek   //anasayfaFragment yemek nesnesi

        binding.editTextYemekId.setText(gelenYemek.id)
        binding.editTextYemekAd.setText(gelenYemek.name)

        binding.buttonGuncelle.setOnClickListener {
            val id = binding.editTextYemekId.text.toString()  //text'e yazılan en son bilgiyi alır
            val name = binding.editTextYemekAd.text.toString()
            guncelle(gelenYemek.id,name)

        }

        return (binding.root)
    }
    fun guncelle(id: Int, name: String){
        Log.e("Yemek Güncelle","$id - $name")
    }

}