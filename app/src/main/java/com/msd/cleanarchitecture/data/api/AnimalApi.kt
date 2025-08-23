package com.msd.cleanarchitecture.data.api

import com.msd.cleanarchitecture.data.dto.AnimalDto
import retrofit2.http.GET

interface AnimalApi {
    @GET("animals")
    suspend fun getAnimals(): List<AnimalDto>
}
