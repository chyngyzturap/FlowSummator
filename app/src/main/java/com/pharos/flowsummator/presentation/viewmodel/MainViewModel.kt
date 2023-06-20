package com.pharos.flowsummator.presentation.viewmodel

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.pharos.flowsummator.data.repository.FlowRepository
import com.pharos.flowsummator.domain.model.FlowResult
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.map
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class MainViewModel @Inject constructor(private val flowRepository: FlowRepository) : ViewModel() {
    private val _flowResult = MutableLiveData<FlowResult>()
    val flowResult: MutableLiveData<FlowResult> = _flowResult

    fun startFlowSummation(input: Int) {
        viewModelScope.launch {
            flowRepository.getFlowSum(input)
                .map { value -> FlowResult(value) }
                .collect { result ->
                    _flowResult.value = result
                }
        }
    }
}

