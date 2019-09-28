package com.yt8492.qiitaclient.common

import androidx.arch.core.executor.ArchTaskExecutor
import androidx.lifecycle.LiveData
import androidx.lifecycle.Observer
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.ExperimentalCoroutinesApi
import kotlinx.coroutines.test.resetMain
import kotlinx.coroutines.test.setMain
import org.spekframework.spek2.dsl.Root

object LiveDataSpekHelper {

    @ExperimentalCoroutinesApi
    fun setup(root: Root) {
        root.beforeEachTest {
            Dispatchers.setMain(Dispatchers.Unconfined)
            ArchTaskExecutor.getInstance().setDelegate(TestArchTaskExecutor())
        }
        root.afterEachTest {
            Dispatchers.resetMain()
            ArchTaskExecutor.getInstance().setDelegate(null)
        }
    }

    fun makeLifecycleToResume(liveData: LiveData<*>) {
        val owner = StubLifecycleOwner().apply {
            markResumed()
        }
        liveData.observe(
            owner,
            Observer { }
        )
    }

    fun makeLifecycleToPause(liveData: LiveData<*>) {
        val owner = StubLifecycleOwner().apply {
            markDestroyed()
        }
        liveData.observe(
            owner,
            Observer { }
        )
    }
}