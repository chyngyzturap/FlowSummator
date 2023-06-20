package com.pharos.flowsummator.data.repository

import kotlinx.coroutines.flow.Flow

interface FlowRepository {
    suspend fun getFlowSum(input: Int): Flow<Int>
}