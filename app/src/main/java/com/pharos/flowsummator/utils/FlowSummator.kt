package com.pharos.flowsummator.utils

import kotlinx.coroutines.delay
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow

class FlowSummator {
    fun sumValues(input: Int): Flow<Int> = flow {
        val flows = Array(input) { index ->
            flow {
                delay((index + 1) * 100L)
                emit(index + 1)
            }
        }

        var sum = 0
        flows.map { flow ->
            flow.collect { value ->
                sum += value
                emit(sum)
            }
        }
    }
}






