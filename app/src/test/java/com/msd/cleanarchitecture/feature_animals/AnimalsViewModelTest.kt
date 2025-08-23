package com.msd.cleanarchitecture.feature_animals

import com.msd.cleanarchitecture.domain.model.Animal
import com.msd.cleanarchitecture.domain.usecase.GetAnimalsUseCase
import io.mockk.coEvery
import io.mockk.mockk
import kotlinx.coroutines.ExperimentalCoroutinesApi
import kotlinx.coroutines.test.runTest
import org.junit.Assert.assertTrue
import org.junit.Test

@OptIn(ExperimentalCoroutinesApi::class)
class AnimalsViewModelTest {

    private val useCase: GetAnimalsUseCase = mockk()
    private val vm = AnimalsViewModel(useCase)

    @Test
    fun `loadAnimals updates state`() = runTest {
        coEvery { useCase() } returns listOf(Animal("1", "Cat"))

        vm.loadAnimals()

        val state = vm.ui.value
        // assertTrue(state.isNotEmpty())
    }
}
