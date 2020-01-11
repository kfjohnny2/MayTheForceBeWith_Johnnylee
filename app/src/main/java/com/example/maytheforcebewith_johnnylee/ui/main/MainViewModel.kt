package com.example.maytheforcebewith_johnnylee.ui.main

import android.util.Log
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.viewModelScope
import com.example.maytheforcebewith_johnnylee.base.BaseViewModel
import com.example.maytheforcebewith_johnnylee.base.UseCaseResult
import com.example.maytheforcebewith_johnnylee.model.people.People
import com.example.maytheforcebewith_johnnylee.network.PeopleApi
import com.example.maytheforcebewith_johnnylee.ui.main.repository.MainRepository
import com.example.maytheforcebewith_johnnylee.ui.main.repository.MainRepositoryImpl
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext
import javax.inject.Inject

class MainViewModel : BaseViewModel() {
    @Inject
    lateinit var peopleApi:PeopleApi

    private val repository by lazy { MainRepositoryImpl(peopleApi) }

    val peopleList = MutableLiveData<List<People>>().apply { value = mutableListOf() }

    init {
        viewModelScope.launch(Dispatchers.Main) { get() }
    }

    internal suspend fun get() {
        val result = withContext(Dispatchers.IO) {
            repository.getPeople()
        }

        when(result){
            is UseCaseResult.Success -> {
                peopleList.value = result.data
                Log.d("DATA", result.data.toString())
            }
            is UseCaseResult.Error -> {
                Log.d("ERROR", result.exception.message!!)
            }
        }
    }

    private fun getPeople(): List<People>? {
        return peopleList.value
    }
}