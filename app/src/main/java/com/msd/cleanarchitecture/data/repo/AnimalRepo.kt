package com.msd.cleanarchitecture.data.repo

import com.msd.cleanarchitecture.domain.model.Animal

interface AnimalRepo {
    suspend fun getAnimals(): List<Animal>
}
