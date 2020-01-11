package com.example.maytheforcebewith_johnnylee.ui.main.repository

import com.example.maytheforcebewith_johnnylee.base.UseCaseResult
import com.example.maytheforcebewith_johnnylee.base.model.Data
import com.example.maytheforcebewith_johnnylee.model.people.People
import com.example.maytheforcebewith_johnnylee.network.PeopleApi
import retrofit2.Response

open class MainRepositoryImpl(private val peopleApi: PeopleApi) : MainRepository{
    override suspend fun getPeople(): UseCaseResult<List<People>> {
        return try{
            val result = peopleApi.getPeople()
            if (result.isSuccessful){
                UseCaseResult.Success(result.body()?.results!!)
            } else{
                UseCaseResult.Error(Throwable(result.message()))
            }
        }catch (ex : Exception){
            UseCaseResult.Error(ex)
        }
    }
}