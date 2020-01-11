package com.example.maytheforcebewith_johnnylee.ui.main.adapter

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import com.example.maytheforcebewith_johnnylee.base.BaseViewModel
import com.example.maytheforcebewith_johnnylee.model.people.People

class PeopleItemViewModel : BaseViewModel(){
    private val peopleNameLiveData = MutableLiveData<String>()

    fun bind(people: People) {
        peopleNameLiveData.postValue(people.name)
    }

    fun getPeopleName(): LiveData<String> {
        return peopleNameLiveData
    }
}