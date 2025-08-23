package com.msd.cleanarchitecture

import androidx.compose.ui.test.junit4.createAndroidComposeRule
import androidx.compose.ui.test.onNodeWithText
import androidx.compose.ui.test.performClick
import com.msd.cleanarchitecture.app.MainActivity
import org.junit.Rule
import org.junit.Test

class AnimalsScreenTest {

    @get:Rule
    val composeTestRule = createAndroidComposeRule<MainActivity>()

    @Test
    fun animalsScreen_showsList() {
        // Launches MainActivity and renders AnimalsScreen()
        composeTestRule.onNodeWithText("Animals").assertExists()
    }

    @Test
    fun animalsScreen_clickAnimal() {
        // If the API returns "Lion", this will check list interaction
        composeTestRule.onNodeWithText("Lion").performClick()
    }
}
