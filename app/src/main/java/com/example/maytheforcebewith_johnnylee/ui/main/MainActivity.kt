package com.example.maytheforcebewith_johnnylee.ui.main

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.databinding.DataBindingUtil
import androidx.lifecycle.ViewModelProviders
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.maytheforcebewith_johnnylee.R
import com.example.maytheforcebewith_johnnylee.databinding.ActivityMainBinding
import com.example.maytheforcebewith_johnnylee.ui.main.adapter.PeopleAdapter

class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding
    private val viewModel by lazy {  ViewModelProviders.of(this).get(MainViewModel::class.java)}
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = DataBindingUtil.setContentView(this,
            R.layout.activity_main
        )
        binding.lifecycleOwner = this

        binding.mainViewModel = viewModel

        configuraRecyclerView()
        binding.btLoadMore.setOnClickListener {
            viewModel.get()
        }
    }

    private fun configuraRecyclerView() {
        binding.rvPeople.adapter = PeopleAdapter(mutableListOf())
        with(binding.rvPeople) {
            layoutManager = LinearLayoutManager(applicationContext)
            setHasFixedSize(true)
        }
    }
}
