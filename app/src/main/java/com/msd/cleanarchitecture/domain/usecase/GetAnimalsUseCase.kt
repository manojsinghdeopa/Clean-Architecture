package com.msd.cleanarchitecture.domain.usecase

import com.msd.cleanarchitecture.data.repo.AnimalRepo
import com.msd.cleanarchitecture.domain.model.Animal

class GetAnimalsUseCase(private val repo: AnimalRepo) {
    suspend operator fun invoke(): List<Animal> = repo.getAnimals()
}
