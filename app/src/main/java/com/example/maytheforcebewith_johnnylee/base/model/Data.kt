package com.example.maytheforcebewith_johnnylee.base.model

import com.example.maytheforcebewith_johnnylee.model.people.People
import com.google.gson.annotations.SerializedName

data class Data(val count : Int,
                @SerializedName("next") val nextUrl : String,
                @SerializedName("previous") val previousUrl : String,
                val results : List<People>)