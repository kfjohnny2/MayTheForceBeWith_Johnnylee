package com.example.maytheforcebewith_johnnylee.ui.main

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.viewModelScope
import com.example.maytheforcebewith_johnnylee.base.BaseViewModel
import com.example.maytheforcebewith_johnnylee.model.people.People
import com.example.maytheforcebewith_johnnylee.network.PeopleApi
import com.example.maytheforcebewith_johnnylee.ui.main.repository.MainRepository
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext
import javax.inject.Inject

class MainViewModel : BaseViewModel() {
    @Inject
    lateinit var peopleApi:PeopleApi

    private val repository by lazy { MainRepository(peopleApi) }

    val peopleList = MutableLiveData<List<People>>().apply { value = mutableListOf() }

    init {
        viewModelScope.launch(Dispatchers.Main) { get() }
    }

    internal suspend fun get() {
        withContext(Dispatchers.IO) {
            val response = repository.getPeople()
            peopleList.postValue(response)

        }
    }

    private fun getPeople(): List<People>? {
        return peopleList.value
    }
}