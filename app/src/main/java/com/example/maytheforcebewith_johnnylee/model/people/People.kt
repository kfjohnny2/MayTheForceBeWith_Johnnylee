package com.example.maytheforcebewith_johnnylee.model.people

import com.example.maytheforcebewith_johnnylee.util.*
import com.google.gson.annotations.SerializedName

data class People(

    @SerializedName(FIELD_PEOPLE_NAME) val name: String,
    @SerializedName(FIELD_PEOPLE_HEIGHT) val height: String,
    @SerializedName(FIELD_PEOPLE_MASS) val mass: String,
    @SerializedName(FIELD_PEOPLE_HAIR_COLOR) val hairColor: String,
    @SerializedName(FIELD_PEOPLE_SKIN_COLOR) val skinColor: String,
    @SerializedName(FIELD_PEOPLE_EYE_COLOR) val eyeColor: String,
    @SerializedName(FIELD_PEOPLE_BIRTH_YEAR) val birthYear: String,
    @SerializedName(FIELD_PEOPLE_GENDER) val gender: String,
    @SerializedName(FIELD_PEOPLE_HOMEWORLD) val homeworld: String,
    @SerializedName(FIELD_PEOPLE_FILMS) val films: List<String>,
    @SerializedName(FIELD_PEOPLE_SPECIES) val species: List<String>,
    @SerializedName(FIELD_PEOPLE_VEHICLES) val vehicles: List<String>,
    @SerializedName(FIELD_PEOPLE_STARSHIPS) val starships: List<String>,
    @SerializedName(FIELD_PEOPLE_CREATED) val created: String,
    @SerializedName(FIELD_PEOPLE_EDITED) val edited: String,
    @SerializedName(FIELD_PERSON_URL) val url: String
)