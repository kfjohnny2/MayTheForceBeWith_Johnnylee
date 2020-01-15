package com.example.maytheforcebewith_johnnylee.ui.details

import android.content.Context
import androidx.lifecycle.ViewModelProviders
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.lifecycle.Observer

import com.example.maytheforcebewith_johnnylee.R
import com.example.maytheforcebewith_johnnylee.application.MayTheForceBeWithApplication
import com.example.maytheforcebewith_johnnylee.databinding.FragmentDetailsBinding
import com.example.maytheforcebewith_johnnylee.util.helpers.*
import kotlinx.android.synthetic.main.fragment_details.*

class DetailsFragment : Fragment() {
    private lateinit var binding: FragmentDetailsBinding
    private val viewModel by lazy { ViewModelProviders.of(this).get(DetailsViewModel::class.java) }
    lateinit var favoriteListPreference: MutableSet<String>

    companion object {
        fun newInstance() = DetailsFragment()

    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = DataBindingUtil.inflate(inflater, R.layout.fragment_details, container, false)
        binding.lifecycleOwner = this

        binding.detailsViewModel = viewModel

        favoriteListPreference = if(getPreferencesSet("favoriteList", context!!) != null){
            getPreferencesSet("favoriteList", context!!)!!
        }else{
            mutableSetOf()
        }

        val person = arguments?.getString("personUrl")

        person?.let { viewModel.getPerson(it) }

        viewModel.personData.observe(this, Observer {
            if (it != null && isFavorite(it.name))
                cbFavorite.isChecked = true
        })


        binding.cbFavorite.setOnCheckedChangeListener { _, isChecked ->
            if (isChecked) {
                viewModel.postFavorite()
            } else {
                viewModel.personData.value?.name?.let { character ->
                    favoriteListPreference.remove(
                        character
                    )
                }
                setPreferencesSet(favoriteListPreference.toList(), "favoriteList", true, context!!)
            }
        }
        viewModel.successRequest.observe(this, Observer {
            when (it) {
                1 -> {
                    binding.cbFavorite.isChecked = true
                    viewModel.personData.value?.name?.let { character ->
                        favoriteListPreference.add(character)
                        setPreferencesSet(favoriteListPreference.toList(), "favoriteList", true, context!!)
                    }
                }
                -1 -> binding.cbFavorite.isChecked = false
            }
        })
        return binding.root
    }

    private fun isFavorite(name : String): Boolean {
        favoriteListPreference.forEach {
            if (it.contains(name))
                return true
        }
        return false
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)

        // TODO: Use the ViewModel
    }

}
