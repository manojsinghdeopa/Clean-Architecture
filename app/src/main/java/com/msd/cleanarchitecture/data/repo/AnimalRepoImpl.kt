package com.msd.cleanarchitecture.data.repo

import com.msd.cleanarchitecture.data.api.AnimalApi
import com.msd.cleanarchitecture.domain.model.Animal

class AnimalRepoImpl(private val api: AnimalApi): AnimalRepo {
    override suspend fun getAnimals(): List<Animal> = api.getAnimals().map { it.toDomain() }
}
