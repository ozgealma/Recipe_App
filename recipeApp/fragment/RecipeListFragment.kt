package com.example.recipeapp.fragment

import android.os.Bundle
import android.view.*
import androidx.fragment.app.Fragment
import androidx.appcompat.app.AppCompatActivity
import androidx.appcompat.widget.SearchView
import androidx.core.view.MenuProvider
import androidx.databinding.DataBindingUtil
import androidx.lifecycle.Lifecycle
import androidx.navigation.Navigation
import com.example.recipeapp.R
import com.example.recipeapp.adapter.RecipeRecyclerAdapter
import com.example.recipeapp.databinding.FragmentRecipeListBinding
import com.example.recipeapp.model.Recipe
import com.example.recipeapp.util.gecisYap
import com.example.recipeapp.viewmodel.RecipeListViewModel
import dagger.hilt.android.AndroidEntryPoint
import kotlinx.coroutines.runBlocking
/*
@AndroidEntryPoint
class RecipeListFragment : Fragment(),SearchView.OnQueryTextListener {

    private lateinit var binding: FragmentRecipeListBinding
    private lateinit var viewModel: RecipeListViewModel
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {

        // Inflate the layout for this fragment
        binding = FragmentRecipeListBinding.inflate(layoutInflater,container,false)


        //tasarımı bağladık
        binding = DataBindingUtil.inflate(inflater, R.layout.fragment_recipe_list, container, false)
        binding.recipeListFragment = this

        binding.recipeListToolBarName = "Tarifler"
        (activity as AppCompatActivity).setSupportActionBar(binding.toolbar)//toolbarı bağladık


        //nUllPointerException hatası veriyor->RecipeRepository->gettAllRecipes() fonksiyonu içindeki// yeni fun yazarak giderildi
        viewModel.recipeList.observe(viewLifecycleOwner) {
            val adapter = RecipeRecyclerAdapter()
            binding.recipeAdapter = adapter
        }


        requireActivity().addMenuProvider(object : MenuProvider {
            override fun onCreateMenu(menu: Menu, menuInflater: MenuInflater) {
                menuInflater.inflate(R.menu.toolbar_menu, menu)//menüyü fragmenta bağladık

                val item = menu.findItem(R.id.action_search)
                val searchView = item.actionView as SearchView

                searchView.setOnQueryTextListener(this@RecipeListFragment)
            }

            override fun onMenuItemSelected(menuItem: MenuItem): Boolean {
                return false
            }

        }, viewLifecycleOwner, Lifecycle.State.RESUMED)

        return binding.root
    }
*/
@AndroidEntryPoint
class RecipeListFragment : Fragment(), SearchView.OnQueryTextListener {
    private lateinit var tasarim: FragmentRecipeListBinding
    private var viewModel: RecipeListViewModel? = null
    private lateinit var recipetList : ArrayList<Recipe>

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {

        //tasarımı bağladık
        tasarim = DataBindingUtil.inflate(inflater, R.layout.fragment_recipe_list, container, false)
        tasarim.recipeListFragment = this

        tasarim.recipeListToolBarName = "Tarifler"
       // (activity as AppCompatActivity).setSupportActionBar(tasarim.toolbar)  ekleyince çöküyor


        //nUllPointerException hatası veriyor->RecipeRepository->gettAllRecipes() fonksiyonu içindeki// yeni fun yazarak giderildi
        viewModel?.recipeList?.observe(viewLifecycleOwner) { data ->
            if (data != null) {
                val adapter = RecipeRecyclerAdapter(recipetList)
                tasarim.recipeAdapter = adapter
            }
        }




        requireActivity().addMenuProvider(object : MenuProvider {
            override fun onCreateMenu(menu: Menu, menuInflater: MenuInflater) {
                menuInflater.inflate(R.menu.toolbar_menu, menu)//menüyü fragmenta bağladık

                val item = menu.findItem(R.id.action_search)
                val searchView = item.actionView as SearchView
                searchView.setOnQueryTextListener(this@RecipeListFragment)
            }

            override fun onMenuItemSelected(menuItem: MenuItem): Boolean {
                return false
            }

        }, viewLifecycleOwner, Lifecycle.State.RESUMED)

        return tasarim.root
    }
    fun fabClick(it: View) {
        Navigation.gecisYap(R.id.action_recipeListFragment_to_addFragment, it)

    }

    override fun onQueryTextSubmit(query: String): Boolean {
        runBlocking {
            viewModel?.search(query)
        }
        return true
    }

    override fun onQueryTextChange(newText: String): Boolean {
        runBlocking {
            viewModel?.search(newText)
        }
        return true
    }

    override fun onResume() {
        super.onResume()
        runBlocking {
            viewModel?.loadRecipe()
        }

    }

}

