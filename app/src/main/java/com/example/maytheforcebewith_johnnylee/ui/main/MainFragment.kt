package com.example.maytheforcebewith_johnnylee.ui.main


import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.lifecycle.ViewModelProviders
import androidx.navigation.findNavController
import androidx.navigation.ui.NavigationUI
import androidx.recyclerview.widget.LinearLayoutManager

import com.example.maytheforcebewith_johnnylee.R
import com.example.maytheforcebewith_johnnylee.databinding.FragmentMainBinding
import com.example.maytheforcebewith_johnnylee.ui.main.adapter.PeopleAdapter

/**
 * A simple [Fragment] subclass.
 */
class MainFragment : Fragment() {
    private lateinit var binding: FragmentMainBinding
    private val viewModel by lazy {  ViewModelProviders.of(this).get(MainViewModel::class.java)}
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        binding = DataBindingUtil.inflate(inflater, R.layout.fragment_main, container, false)
        binding.lifecycleOwner = this

        binding.mainViewModel = viewModel

        configuraRecyclerView()
        binding.btLoadMore.setOnClickListener {
            viewModel.get()
        }
        return binding.root
    }

    private fun navigateToDetails(personDetailsUrl : String){
        val directions = MainFragmentDirections.actionMainFragmentToDetailsFragment()
        directions.personUrl = personDetailsUrl
        binding.root.findNavController().navigate(directions)
    }

    private fun configuraRecyclerView() {
        binding.rvPeople.adapter = PeopleAdapter(
            mutableListOf()) { person : String  -> navigateToDetails(person)}
        with(binding.rvPeople) {
            layoutManager = LinearLayoutManager(context)
            setHasFixedSize(true)
        }
    }
}
