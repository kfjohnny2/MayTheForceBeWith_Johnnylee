package com.example.maytheforcebewith_johnnylee.network

import com.example.maytheforcebewith_johnnylee.base.model.Data
import com.example.maytheforcebewith_johnnylee.model.people.People
import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Path
import retrofit2.http.Url

interface PeopleApi {

    /**
     * Get the list of the people from the API
     */
    @GET("people")
    suspend fun getPeople(): Response<Data>

    /**
     * Get the list of the people from the API
     * @param nextUrl Url for the next page of results from the API
     */
    @GET
    suspend fun getPeople(@Url nextUrl : String): Response<Data>

    /**
     * Get details of a character from the API
     */
    @GET
    suspend fun getPerson(@Url personUrl : String): Response<People>
}