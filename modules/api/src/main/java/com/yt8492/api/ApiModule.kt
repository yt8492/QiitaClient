package com.yt8492.api

import com.yt8492.api.infra.InfraModule
import dagger.Module

@Module(
    includes = [InfraModule::class]
)
class ApiModule {
}