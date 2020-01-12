package com.example.maytheforcebewith_johnnylee.ui.details.repository

import com.example.maytheforcebewith_johnnylee.base.UseCaseResult
import com.example.maytheforcebewith_johnnylee.model.people.People
import com.example.maytheforcebewith_johnnylee.network.PeopleApi

open class DetailsRepositoryImpl(private val peopleApi: PeopleApi) : DetailsRepository {
    override suspend fun getPerson(personUrl: String): UseCaseResult<People> {
        return try {
            val result = peopleApi.getPerson(personUrl)
            if (result.isSuccessful) {
                UseCaseResult.Success(result.body()!!)
            } else {
                UseCaseResult.Error(Throwable(result.message()))
            }
        } catch (ex: Exception) {
            UseCaseResult.Error(ex)
        }
    }
}