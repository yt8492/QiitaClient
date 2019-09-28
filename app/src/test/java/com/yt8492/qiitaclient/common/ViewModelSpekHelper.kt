package com.yt8492.qiitaclient.common

import androidx.arch.core.executor.ArchTaskExecutor
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.ExperimentalCoroutinesApi
import kotlinx.coroutines.test.resetMain
import kotlinx.coroutines.test.setMain
import org.spekframework.spek2.dsl.Root

object ViewModelSpekHelper {

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
}