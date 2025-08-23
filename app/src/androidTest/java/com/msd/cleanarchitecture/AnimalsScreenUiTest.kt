
package com.msd.cleanarchitecture

import androidx.compose.ui.test.junit4.createAndroidComposeRule
import androidx.compose.ui.test.onNodeWithText
import com.msd.cleanarchitecture.app.MainActivity
import org.junit.Rule
import org.junit.Test

class AnimalsScreenUiTest {

    @get:Rule
    val composeRule = createAndroidComposeRule<MainActivity>()

    @Test
    fun appLaunches_andShowsUI() {
        // Since our default screen triggers a load, this is a smoke test.
        // In a real app, you'd inject a fake repo via a debug-only DI module.
        // Here, we just verify the activity launches without crashing.
        composeRule.onNodeWithText("Oops:", substring = true).assertDoesNotExist()
    }
}
