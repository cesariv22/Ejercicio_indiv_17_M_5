package com.example.ejercicio_indiv_17_m_5

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ArrayAdapter
import com.example.ejercicio_indiv_17_m_5.databinding.ListItemCountryBinding

class CountryAdapter(context: Context, private val countries: List<Country>) :
    ArrayAdapter<Country>(context, 0, countries) {

    override fun getView(position: Int, convertView: View?, parent: ViewGroup): View {
        val binding: ListItemCountryBinding
        var view = convertView

        if (view == null) {
            binding = ListItemCountryBinding.inflate(LayoutInflater.from(context), parent, false)
            view = binding.root
            view.tag = binding
        } else {
            binding = view.tag as ListItemCountryBinding
        }

        val country = countries[position]
        binding.countryNameTextView.text = country.name

        return view
    }
    override fun getItemId(position: Int): Long {
        return position.toLong()
    }
}
