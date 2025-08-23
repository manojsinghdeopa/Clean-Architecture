
package com.msd.cleanarchitecture.feature_animals

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.msd.cleanarchitecture.domain.model.Animal
import com.msd.cleanarchitecture.domain.usecase.GetAnimalsUseCase
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.launch
import javax.inject.Inject

data class AnimalsUiState(
    val loading: Boolean = false,
    val items: List<Animal> = emptyList(),
    val error: String? = null
)

@HiltViewModel
class AnimalsViewModel @Inject constructor(
    private val getAnimals: GetAnimalsUseCase
) : ViewModel() {

    private val _ui = MutableStateFlow(AnimalsUiState())
    val ui: StateFlow<AnimalsUiState> = _ui

    fun load() = viewModelScope.launch {
        _ui.value = AnimalsUiState(loading = true)
        runCatching { getAnimals() }
            .onSuccess { list -> _ui.value = AnimalsUiState(items = list) }
            .onFailure { e -> _ui.value = AnimalsUiState(error = e.message ?: "Unknown error") }
    }

    // Helper for unit tests (not strictly necessary, but convenient)
    fun loadAnimals() = load()
}
