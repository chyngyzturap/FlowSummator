package com.pharos.flowsummator.data.repository

import com.pharos.flowsummator.utils.FlowSummator
import kotlinx.coroutines.delay
import kotlinx.coroutines.flow.*

class FlowRepositoryImpl(private val flowSummator: FlowSummator) : FlowRepository {
    override suspend fun getFlowSum(input: Int): Flow<Int> {
        return flowSummator.sumValues(input)
    }
}