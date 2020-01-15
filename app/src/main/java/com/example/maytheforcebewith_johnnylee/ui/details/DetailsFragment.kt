package com.example.maytheforcebewith_johnnylee.ui.details

import androidx.lifecycle.ViewModelProviders
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.lifecycle.Observer
import androidx.navigation.findNavController
import androidx.navigation.fragment.navArgs

import com.example.maytheforcebewith_johnnylee.R
import com.example.maytheforcebewith_johnnylee.databinding.FragmentDetailsBinding

class DetailsFragment : Fragment() {
    private lateinit var binding: FragmentDetailsBinding
    private val viewModel by lazy {  ViewModelProviders.of(this).get(DetailsViewModel::class.java)}

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

        val person = arguments?.getString("personUrl")

        person?.let { viewModel.getPerson(it) }
//        binding.cbFavorite.setOnCheckedChangeListener { _, isChecked ->
//            if (isChecked){
//                viewModel.postFavorite()
//            }
//        }
//
//        viewModel.successRequest.observe(this, Observer {
//            when(it){
//                1 -> binding.cbFavorite.isChecked = true
//                -1 -> binding.cbFavorite.isChecked = false
//            }
//        })
        return binding.root
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)
        // TODO: Use the ViewModel
    }

}
