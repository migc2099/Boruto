package com.migc.borutoapp.domain.use_cases.read_onboarding

import com.migc.borutoapp.data.repository.Repository
import kotlinx.coroutines.flow.Flow

class ReadOnBoardingUseCase(private val repository: Repository) {

    suspend fun invoke(): Flow<Boolean> {
        return repository.readOnBoardingState()
    }

}