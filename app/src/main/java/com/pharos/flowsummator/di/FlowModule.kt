package com.pharos.flowsummator.di

import com.pharos.flowsummator.data.repository.FlowRepository
import com.pharos.flowsummator.data.repository.FlowRepositoryImpl
import com.pharos.flowsummator.utils.FlowSummator
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent

@Module
@InstallIn(SingletonComponent::class)
object FlowModule {

    @Provides
    fun provideFlowRepository(flowSummator: FlowSummator): FlowRepository {
        return FlowRepositoryImpl(flowSummator)
    }

    @Provides
    fun provideFlowSummator(): FlowSummator {
        return FlowSummator()
    }
}
