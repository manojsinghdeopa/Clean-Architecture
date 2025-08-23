package com.msd.cleanarchitecture.domain

import com.msd.cleanarchitecture.data.repo.AnimalRepo
import com.msd.cleanarchitecture.domain.model.Animal
import com.msd.cleanarchitecture.domain.usecase.GetAnimalsUseCase
import io.mockk.coEvery
import io.mockk.mockk
import kotlinx.coroutines.runBlocking
import org.junit.Assert.assertEquals
import org.junit.Test

class GetAnimalsUseCaseTest {

    private val repo: AnimalRepo = mockk()
    private val useCase = GetAnimalsUseCase(repo)

    @Test
    fun `should return animals from repo`() = runBlocking {
        val expected = listOf(Animal("1", "Dog"))
        coEvery { repo.getAnimals() } returns expected

        val result = useCase()

        assertEquals(expected, result)
    }
}
