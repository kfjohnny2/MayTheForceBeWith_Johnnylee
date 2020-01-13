package com.example.maytheforcebewith_johnnylee.ui.details.repository

import com.example.maytheforcebewith_johnnylee.base.UseCaseResult
import com.example.maytheforcebewith_johnnylee.model.people.People

interface DetailsRepository {
    suspend fun getPerson(personUrl: String) : UseCaseResult<People>

}