package com.migc.borutoapp.data.repository

import com.migc.borutoapp.domain.repository.DataStoreOperations
import kotlinx.coroutines.flow.Flow
import javax.inject.Inject

class Repository @Inject constructor(
    private val dataStore: DataStoreOperations
) {

    suspend fun saveOnBoardingState(completed: Boolean) {
        dataStore.saveOnBoardingState(completed)
    }

    suspend fun readOnBoardingState(): Flow<Boolean> {
        return dataStore.readOnBoardingState()
    }

}