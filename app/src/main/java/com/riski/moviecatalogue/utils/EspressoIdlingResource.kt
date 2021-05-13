package com.riski.moviecatalogue.utils

import androidx.test.espresso.idling.CountingIdlingResource

object EspressoIdlingResource {
    private const val RESOURCE = "GLOBAL"
    private val espTestIdlingRes = CountingIdlingResource(RESOURCE)

    fun increment() {
        espTestIdlingRes.increment()
    }

    fun decrement() {
        espTestIdlingRes.decrement()
    }
}