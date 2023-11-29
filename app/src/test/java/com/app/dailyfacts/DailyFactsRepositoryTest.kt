package com.app.dailyfacts

import android.content.Context
import androidx.test.platform.app.InstrumentationRegistry
import com.app.dailyfacts.model.Facts
import com.app.dailyfacts.repository.DailyFactsRepository
import com.app.dailyfacts.repository.RestService.ApiService
import com.google.gson.Gson
import io.reactivex.Observable
import org.junit.Before
import org.junit.Test
import org.junit.runner.RunWith
import org.mockito.Mockito
import org.mockito.junit.MockitoJUnitRunner

@RunWith(MockitoJUnitRunner::class)
class DailyFactsRepositoryTest {
    private var context: Context? = null
    private var dailyFactsRepository: DailyFactsRepository?= null
    private val apiService : ApiService = Mockito.mock(ApiService::class.java)

    @Before
    fun setUp() {
        context = InstrumentationRegistry.getInstrumentation().context
        dailyFactsRepository = DailyFactsRepository(apiService)
    }

    @Test
    fun testgetDailyFacts() {
        val jsonString: String? = JsonUtils.loadJsonFromAsset(context!!, "DailyFacts.json")
        val facts: Facts? = Gson().fromJson(jsonString, Facts::class.java)
        Mockito.`when`(apiService.dailyFacts).thenReturn(Observable.just(facts))
    }
}