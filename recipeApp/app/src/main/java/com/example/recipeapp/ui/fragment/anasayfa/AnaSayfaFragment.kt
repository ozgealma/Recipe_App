package com.example.recipeapp.ui.fragment.anasayfa

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.View
import androidx.fragment.app.viewModels
import com.example.recipeapp.R
import com.example.recipeapp.databinding.FragmentAnaSayfaBinding
import com.example.recipeapp.ui.adapter.RecipeAdapter
import com.google.android.material.snackbar.Snackbar

class AnaSayfaFragment : Fragment(R.layout.fragment_ana_sayfa) {

    private lateinit var binding: FragmentAnaSayfaBinding
    private lateinit var adapter: RecipeAdapter
    private val viewModel: AnaSayfaViewModel by viewModels()

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        binding=FragmentAnaSayfaBinding.bind(view)
        binding.rv.setHasFixedSize(true)
        viewModel.getReceiptList()

        viewModel.receiptList.observe(viewLifecycleOwner) {
            if (it != null) {
                adapter = RecipeAdapter(it)
                binding.rv.adapter = adapter
                adapter.notifyDataSetChanged()
            } else {
                Snackbar.make(requireView(), "liste boş", Snackbar.LENGTH_LONG).show()
            }
        }
    }
}


/*
      binding.fab.setOnClickListener {
          Navigation.findNavController(it).navigate(R.id.yemekKayitGecis)
      }


      binding.searchView.setOnQueryTextListener(object : OnQueryTextListener {

          //Harf girdikçe/sildikçe sonuç getiren fonksiyon
          override fun onQueryTextChange(newText: String): Boolean {
              ara(newText)
              return true
          }

          //Arama iconuna bastığımızda sonuç getiren fonksiyon
          override fun onQueryTextSubmit(query: String): Boolean {
              ara(query)
              return true
          }
      })

       */

/*
fun ara(aramaKelimesi: String) {
    Log.e("Kişi Ara", aramaKelimesi)
}
 */