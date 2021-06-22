package com.riski.moviecatalogue.utils

import android.os.Handler
import android.os.Looper
import java.util.concurrent.Executor
import java.util.concurrent.Executors

class AppExecutors private constructor(
    private val diskIO : Executor,
    private val networkIo : Executor,
    private val mainThread : Executor
){
    companion object{
        const val THREAD_COUNT = 3
    }

    constructor() : this (
        Executors.newSingleThreadExecutor(),
        Executors.newFixedThreadPool(THREAD_COUNT),
        MainThreadExecutor()

    )

    fun diskIO() : Executor = diskIO

    fun networkIo() : Executor = networkIo

    fun mainThread() : Executor = mainThread

    private class MainThreadExecutor() : Executor{
        private val mainThreadHandler = Handler(Looper.getMainLooper())

        override fun execute(command: Runnable) {
            mainThreadHandler.post(command)
        }
    }
}