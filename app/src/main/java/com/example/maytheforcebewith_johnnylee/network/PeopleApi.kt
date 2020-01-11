package com.example.maytheforcebewith_johnnylee.network

import com.example.maytheforcebewith_johnnylee.base.model.Data
import retrofit2.Response
import retrofit2.http.GET

interface PeopleApi {

    /**
     * Get the list of the people from the API
     */
    @GET("people")
    suspend fun getPeople(): Response<Data>
}