package com.example.ejercicio_indiv_17_m_5

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.AdapterView
import android.widget.ListView
import android.widget.TextView
import com.example.ejercicio_indiv_17_m_5.databinding.ActivityMainBinding
import java.text.NumberFormat
import java.util.Locale


class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding
    private lateinit var countryListView: ListView
    private lateinit var selectedCountryTextView: TextView

    private val countriesData = listOf(
        Country("Argentina", 45195777),
        Country("Bolivia", 11673021),
        Country("Brasil", 213993437),
        Country("Chile", 19773003),
        Country("Colombia", 51049498),
        Country("Ecuador", 17643054),
        Country("Guyana", 786552),
        Country("Paraguay", 7631912),
        Country("Perú", 32971854),
        Country("Surinam", 586632),
        Country("Uruguay", 3431000),
        Country("Venezuela", 28435940)
    )


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        countryListView = binding.list1
        selectedCountryTextView = binding.tv1

        val adapter = CountryAdapter(this, countriesData)
        countryListView.adapter = adapter

        countryListView.onItemClickListener =
            AdapterView.OnItemClickListener { _, _, position, _ ->
                val selectedCountry = countriesData[position]
                val population = getPopulationByCountry(selectedCountry)
                val textToShow = getString(R.string.habitantes_de_pais, selectedCountry.name, population)
                selectedCountryTextView.text = textToShow
            }
    }

    private fun getPopulationByCountry(country: Country): String {
        val population = country.population
        val numberFormat = NumberFormat.getNumberInstance(Locale.getDefault())
        return  numberFormat.format(population)
    }
}
