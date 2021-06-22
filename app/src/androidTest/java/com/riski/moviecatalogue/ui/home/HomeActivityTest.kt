package com.riski.moviecatalogue.ui.home

import android.os.SystemClock
import androidx.recyclerview.widget.RecyclerView
import androidx.test.espresso.Espresso.onView
import androidx.test.espresso.IdlingRegistry
import androidx.test.espresso.action.ViewActions.*
import androidx.test.espresso.assertion.ViewAssertions.matches
import androidx.test.espresso.contrib.RecyclerViewActions
import androidx.test.espresso.contrib.ViewPagerActions
import androidx.test.espresso.matcher.ViewMatchers.*
import androidx.test.ext.junit.rules.ActivityScenarioRule
import com.riski.moviecatalogue.R
import com.riski.moviecatalogue.utils.DataDummy
import com.riski.moviecatalogue.utils.EspressoIdlingResource
import org.junit.After
import org.junit.Before
import org.junit.Rule
import org.junit.Test

class HomeActivityTest {

    private val dummyMovie = DataDummy.generateDummyMovies()
    private val dummyTvShow = DataDummy.generateDummyTvShows()

    @get:Rule
    var activityRule = ActivityScenarioRule(HomeActivity::class.java)

    @Before
    fun setUp() {
        IdlingRegistry.getInstance().register(EspressoIdlingResource.espTestIdlingRes)
    }

    @After
    fun tearDown() {
        IdlingRegistry.getInstance().unregister(EspressoIdlingResource.espTestIdlingRes)
    }

    @Test
    fun loadMovies() {
        onView(withId(R.id.rv_movie)).check(matches(isDisplayed()))
        onView(withId(R.id.rv_movie)).perform(RecyclerViewActions.scrollToPosition<RecyclerView.ViewHolder>(dummyMovie.size))
    }

    @Test
    fun loadFavoriteMovie() {
        onView(withId(R.id.nav_favorite)).perform(click())
        onView(withId(R.id.rv_movie)).check(matches(isDisplayed()))
        onView(withId(R.id.rv_movie)).perform(RecyclerViewActions.scrollToPosition<RecyclerView.ViewHolder>(3))
    }

    @Test
    fun loadDetailMovie() {
        onView(withId(R.id.rv_movie)).perform(RecyclerViewActions.actionOnItemAtPosition<RecyclerView.ViewHolder>(0, click()))
        onView(withId(R.id.poster)).check(matches(isDisplayed()))
        onView(withId(R.id.tv_date)).check(matches(isDisplayed()))
        onView(withId(R.id.tv_genre_list)).check(matches(isDisplayed()))
        onView(withId(R.id.tv_budget_value)).check(matches(isDisplayed()))
        onView(withId(R.id.tv_revenue_value)).check(matches(isDisplayed()))
        onView(withId(R.id.tv_title)).check(matches(isDisplayed()))
        onView(withId(R.id.tv_overview_desc)).check(matches(isDisplayed()))
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
        onView(withId(R.id.tv_genre_list)).check(matches(isDisplayed()))
        onView(withId(R.id.tv_title)).check(matches(isDisplayed()))
        onView(withId(R.id.tv_overview_desc)).check(matches(isDisplayed()))
    }

    @Test
    fun loadFavoriteTvShow() {
        onView(withId(R.id.nav_favorite)).perform(click())
        onView(withId(R.id.view_favorite)).perform(ViewPagerActions.scrollRight())
        onView(withId(R.id.rv_tv_show_fav)).check(matches(isDisplayed()))
        onView(withId(R.id.rv_tv_show_fav)).perform(RecyclerViewActions.scrollToPosition<RecyclerView.ViewHolder>(3))
    }

    @Test
    fun addDeleteFavoriteMovie() {
        loadDetailMovie()
        onView(withId(R.id.favorite)).perform(click())
        onView(isRoot()).perform(pressBack())
        loadFavoriteMovie()
        onView(withId(R.id.rv_movie)).perform(RecyclerViewActions.actionOnItemAtPosition<RecyclerView.ViewHolder>(0, click()))
        onView(withId(R.id.favorite)).perform(click())
    }

    @Test
    fun addDeleteFavoriteTvShow() {
        loadDetailTvShow()
        onView(withId(R.id.favorite)).perform(click())
        onView(isRoot()).perform(pressBack())
        loadFavoriteTvShow()
        onView(withId(R.id.rv_tv_show_fav)).perform(RecyclerViewActions.actionOnItemAtPosition<RecyclerView.ViewHolder>(0, click()))
        onView(withId(R.id.favorite)).perform(click())
    }

}