package com.example.maytheforcebewith_johnnylee.network

import com.example.maytheforcebewith_johnnylee.base.model.Data
import com.example.maytheforcebewith_johnnylee.model.people.People
import retrofit2.Call
import retrofit2.Response
import retrofit2.http.*

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

    /**
     * Post character as favorite
     */
    @POST
    suspend fun postFavorite(@Body favoritePerson : People, @Url webhookUrl: String = "https://webhook.site/3a242483-95d7-435d-a667-dab9cf18255a"): Response<People>
}