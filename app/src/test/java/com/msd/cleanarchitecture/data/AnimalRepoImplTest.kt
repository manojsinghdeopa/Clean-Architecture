package com.msd.cleanarchitecture.data

import com.msd.cleanarchitecture.data.api.AnimalApi
import com.msd.cleanarchitecture.data.repo.AnimalRepoImpl
import kotlinx.coroutines.runBlocking
import okhttp3.mockwebserver.MockResponse
import okhttp3.mockwebserver.MockWebServer
import org.junit.After
import org.junit.Assert.assertEquals
import org.junit.Before
import org.junit.Test
import retrofit2.Retrofit
import retrofit2.converter.moshi.MoshiConverterFactory

class AnimalRepoImplTest {

    private lateinit var server: MockWebServer
    private lateinit var api: AnimalApi

    @Before
    fun setup() {
        server = MockWebServer()
        api = Retrofit.Builder()
            .baseUrl(server.url("/"))
            .addConverterFactory(MoshiConverterFactory.create())
            .build()
            .create(AnimalApi::class.java)
    }

    @After
    fun teardown() {
        server.shutdown()
    }

    @Test
    fun `repo fetches animals from API`() = runBlocking {
        server.enqueue(MockResponse().setBody("[{\"id\":\"1\",\"name\":\"Lion\"}]"))

        val repo = AnimalRepoImpl(api)
        val result = repo.getAnimals()

        assertEquals("Lion", result.first().name)
    }
}
