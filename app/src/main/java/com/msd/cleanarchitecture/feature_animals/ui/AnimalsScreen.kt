
package com.msd.cleanarchitecture.feature_animals.ui

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.CircularProgressIndicator
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.hilt.navigation.compose.hiltViewModel
import com.msd.cleanarchitecture.feature_animals.AnimalsViewModel

@Composable
fun AnimalsScreen(vm: AnimalsViewModel = hiltViewModel()) {
    val state by vm.ui.collectAsStateWithLifecycleCompat()

    LaunchedEffect(Unit) { vm.load() }

    when {
        state.loading -> Box(Modifier.fillMaxSize()) { CircularProgressIndicator(Modifier.align(Alignment.Center)) }
        state.error != null -> Text("Oops: ${state.error}")
        else -> LazyColumn {
            items(state.items) { animal ->
                Text(text = animal.name, style = MaterialTheme.typography.bodyLarge)
            }
        }
    }
}

// Lightweight compatibility wrapper for collectAsStateWithLifecycle without bringing in lifecycle-compose dependency in this snippet
@Composable
private fun <T> kotlinx.coroutines.flow.StateFlow<T>.collectAsStateWithLifecycleCompat(): androidx.compose.runtime.State<T> {
    // In a full app, use androidx.lifecycle.compose:compose-runtime and collectAsStateWithLifecycle
    return this.collectAsState(initial = this.value)
}
