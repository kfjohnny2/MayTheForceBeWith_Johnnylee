package com.example.maytheforcebewith_johnnylee.ui.main.repository

import com.example.maytheforcebewith_johnnylee.base.UseCaseResult
import com.example.maytheforcebewith_johnnylee.base.model.Data
import com.example.maytheforcebewith_johnnylee.model.people.People
import com.example.maytheforcebewith_johnnylee.network.PeopleApi
import retrofit2.Response

interface MainRepository{
    open suspend fun getPeople() : UseCaseResult<List<People>>
}