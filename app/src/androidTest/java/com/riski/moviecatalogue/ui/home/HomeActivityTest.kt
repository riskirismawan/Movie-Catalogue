package com.riski.moviecatalogue.ui.home

import androidx.recyclerview.widget.RecyclerView
import androidx.test.espresso.Espresso.onView
import androidx.test.espresso.action.ViewActions.click
import androidx.test.espresso.assertion.ViewAssertions.matches
import androidx.test.espresso.contrib.RecyclerViewActions
import androidx.test.espresso.matcher.ViewMatchers.*
import androidx.test.ext.junit.rules.ActivityScenarioRule
import com.riski.moviecatalogue.R
import com.riski.moviecatalogue.utils.DataDummy
import org.junit.Assert.*
import org.junit.Rule
import org.junit.Test

class HomeActivityTest {

    private val dummyMovie = DataDummy.generateDummyMovies()
    private val dummyTvShow = DataDummy.generateDummyTvShows()

    @get:Rule
    var activityRule = ActivityScenarioRule(HomeActivity::class.java)

    @Test
    fun loadMovies() {
        onView(withId(R.id.rv_movie)).check(matches(isDisplayed()))
        onView(withId(R.id.rv_movie)).perform(RecyclerViewActions.scrollToPosition<RecyclerView.ViewHolder>(dummyMovie.size))
    }

    @Test
    fun loadDetailMovie() {
        onView(withId(R.id.rv_movie)).perform(RecyclerViewActions.actionOnItemAtPosition<RecyclerView.ViewHolder>(0, click()))
        onView(withId(R.id.poster)).check(matches(isDisplayed()))
        onView(withId(R.id.tv_date)).check(matches(isDisplayed()))
        onView(withId(R.id.tv_date)).check(matches(withText(dummyMovie[0].releaseDate)))
        onView(withId(R.id.tv_genre_list)).check(matches(isDisplayed()))
        onView(withId(R.id.tv_genre_list)).check(matches(withText(dummyMovie[0].genre)))
        onView(withId(R.id.tv_budget_value)).check(matches(isDisplayed()))
        onView(withId(R.id.tv_budget_value)).check(matches(withText(dummyMovie[0].budget)))
        onView(withId(R.id.tv_revenue_value)).check(matches(isDisplayed()))
        onView(withId(R.id.tv_revenue_value)).check(matches(withText(dummyMovie[0].revenue)))
        onView(withId(R.id.tv_title)).check(matches(isDisplayed()))
        onView(withId(R.id.tv_title)).check(matches(withText(dummyMovie[0].title)))
        onView(withId(R.id.tv_overview_desc)).check(matches(isDisplayed()))
        onView(withId(R.id.tv_overview_desc)).check(matches(withText(dummyMovie[0].overview)))
    }

    @Test
    fun loadTvShow() {
        onView(withId(R.id.nav_tv_show)).perform(click())
        onView(withId(R.id.rv_tv_show)).check(matches(isDisplayed()))
        onView(withId(R.id.rv_tv_show)).perform(RecyclerViewActions.scrollToPosition<RecyclerView.ViewHolder>(dummyTvShow.size))
    }

    @Test
    fun loadDetailTvShow() {
        onView(withId(R.id.nav_tv_show)).perform(click())
        onView(withId(R.id.rv_tv_show)).perform(RecyclerViewActions.actionOnItemAtPosition<RecyclerView.ViewHolder>(0, click()))
        onView(withId(R.id.poster)).check(matches(isDisplayed()))
        onView(withId(R.id.tv_date)).check(matches(isDisplayed()))
        onView(withId(R.id.tv_date)).check(matches(withText(dummyTvShow[0].releaseDate)))
        onView(withId(R.id.tv_genre_list)).check(matches(isDisplayed()))
        onView(withId(R.id.tv_genre_list)).check(matches(withText(dummyTvShow[0].genre)))
        onView(withId(R.id.tv_title)).check(matches(isDisplayed()))
        onView(withId(R.id.tv_title)).check(matches(withText(dummyTvShow[0].title)))
        onView(withId(R.id.tv_overview_desc)).check(matches(isDisplayed()))
        onView(withId(R.id.tv_overview_desc)).check(matches(withText(dummyTvShow[0].overview)))
    }

}