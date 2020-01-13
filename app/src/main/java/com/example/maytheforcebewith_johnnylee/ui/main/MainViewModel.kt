package com.example.maytheforcebewith_johnnylee.ui.main

import android.util.Log
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.viewModelScope
import com.example.maytheforcebewith_johnnylee.base.BaseViewModel
import com.example.maytheforcebewith_johnnylee.base.UseCaseResult
import com.example.maytheforcebewith_johnnylee.model.people.People
import com.example.maytheforcebewith_johnnylee.network.PeopleApi
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
    val nextUrl = MutableLiveData<String>().apply { value = "firstPage" }
    val offset = MutableLiveData<Int>().apply { value = 0 }
    init {
        get()
    }

    fun get() {
        viewModelScope.launch {

            val result = withContext(Dispatchers.IO) {
                when {
                    nextUrl.value == "firstPage" -> repository.getPeople()
                    !nextUrl.value.isNullOrBlank() -> {
                        repository.getPeople(nextUrl.value!!)
                    }
                    else -> UseCaseResult.Error(Throwable("End of list"))
                }
            }

            when(result){
                is UseCaseResult.Success -> {
                    peopleList.value = result.data.results
                    offset.value?.plus(result.data.results.size)
                    nextUrl.value = result.data.nextUrl

                    Log.d("DATA", result.data.toString())
                }
                is UseCaseResult.Error -> {
                    Log.d("ERROR", result.exception.message!!)
                }
            }
        }
    }

    private fun getPeople(): List<People>? {
        return peopleList.value
    }
}