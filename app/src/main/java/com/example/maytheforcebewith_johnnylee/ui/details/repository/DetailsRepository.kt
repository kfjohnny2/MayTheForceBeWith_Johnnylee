package com.example.maytheforcebewith_johnnylee.ui.details.repository

import com.example.maytheforcebewith_johnnylee.base.UseCaseResult
import com.example.maytheforcebewith_johnnylee.model.people.People
import okhttp3.Response

interface DetailsRepository {
    suspend fun getPerson(personUrl: String) : UseCaseResult<People>
    suspend fun postFavorite(favoritePerson: People) : UseCaseResult<Int>

}