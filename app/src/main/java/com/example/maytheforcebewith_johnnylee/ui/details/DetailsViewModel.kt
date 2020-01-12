package com.example.maytheforcebewith_johnnylee.ui.details

import android.util.Log
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.maytheforcebewith_johnnylee.base.BaseViewModel
import com.example.maytheforcebewith_johnnylee.base.UseCaseResult
import com.example.maytheforcebewith_johnnylee.model.people.People
import com.example.maytheforcebewith_johnnylee.network.PeopleApi
import com.example.maytheforcebewith_johnnylee.ui.details.repository.DetailsRepositoryImpl
import com.example.maytheforcebewith_johnnylee.ui.main.repository.MainRepositoryImpl
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext
import javax.inject.Inject

class DetailsViewModel : BaseViewModel() {
    @Inject
    lateinit var peopleApi: PeopleApi

    private val repository by lazy { DetailsRepositoryImpl(peopleApi) }

    val personData = MutableLiveData<People>().apply { value = null }

    fun getPerson(personUrl: String) {
        viewModelScope.launch {

            val result = withContext(Dispatchers.IO) {
                repository.getPerson(personUrl)
            }

            when(result){
                is UseCaseResult.Success -> {
                    personData.value = result.data
                    Log.d("DATA", result.data.toString())
                }
                is UseCaseResult.Error -> {
                    Log.d("ERROR", result.exception.message!!)
                }
            }
        }
    }
    // TODO: Implement the ViewModel
}
