package com.example.maytheforcebewith_johnnylee.ui.main.repository

import com.example.maytheforcebewith_johnnylee.base.model.Data
import com.example.maytheforcebewith_johnnylee.model.people.People
import com.example.maytheforcebewith_johnnylee.network.PeopleApi
import retrofit2.Response

open class MainRepository(private val peopleApi: PeopleApi){
    open suspend fun getPeople() : List<People>? {
        val response: Response<Data> = peopleApi.getPeople()
        if(response.isSuccessful){
            return response.body()?.results
        }
        return null
    }
}