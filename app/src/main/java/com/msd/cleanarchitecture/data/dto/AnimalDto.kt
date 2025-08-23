package com.msd.cleanarchitecture.data.dto

import com.msd.cleanarchitecture.domain.model.Animal

data class AnimalDto(val id: String, val name: String) {
    fun toDomain() = Animal(id, name)
}
