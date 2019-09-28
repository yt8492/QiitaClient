package com.yt8492.qiitaclient.common

import androidx.lifecycle.Lifecycle
import androidx.lifecycle.LifecycleOwner
import androidx.lifecycle.LifecycleRegistry

class StubLifecycleOwner : LifecycleOwner {

    private val registry = LifecycleRegistry(this)
    override fun getLifecycle(): Lifecycle {
        return registry
    }

    fun markInitialized() {
        registry.currentState = Lifecycle.State.INITIALIZED
    }

    fun markCreated() {
        registry.currentState = Lifecycle.State.CREATED
    }

    fun markStarted() {
        registry.currentState = Lifecycle.State.STARTED
    }

    fun markResumed() {
        registry.currentState = Lifecycle.State.RESUMED
    }

    fun markDestroyed() {
        registry.currentState = Lifecycle.State.DESTROYED
    }
}
