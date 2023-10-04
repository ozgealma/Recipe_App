package com.example.recipeapp.ui.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.recipeapp.data.entity.Recipe
import com.example.recipeapp.databinding.CardTasarimBinding

class RecipeAdapter(private val yemeklerListesi: List<Recipe>)
    : RecyclerView.Adapter<RecipeAdapter.CardTasarimTutucu>() {

    //Card tasarımı temsil eden inner class;
    inner class CardTasarimTutucu(val tasarim: CardTasarimBinding) :
        RecyclerView.ViewHolder(tasarim.root)

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): CardTasarimTutucu {
        //viewBinding işlemini gerçekleştirdik

        val binding = CardTasarimBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return CardTasarimTutucu(binding)
    }

    override fun getItemCount(): Int {
        //kaç tane veri göstereceğimizi belirtiyor
        return yemeklerListesi.size
    }

    override fun onBindViewHolder(holder: CardTasarimTutucu, position: Int) {
        //tıklama işlemleri vs. -  card la ilgili tasarımlar
        val yemek = yemeklerListesi.get(position)
        val t = holder.tasarim

        t.textViewYemekAd.text = yemek.name

    }
}