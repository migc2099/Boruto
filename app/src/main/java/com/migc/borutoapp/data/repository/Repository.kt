package com.migc.borutoapp.data.repository

import androidx.paging.PagingData
import com.migc.borutoapp.domain.model.Hero
import com.migc.borutoapp.domain.repository.DataStoreOperations
import com.migc.borutoapp.domain.repository.RemoteDataSource
import kotlinx.coroutines.flow.Flow
import javax.inject.Inject

class Repository @Inject constructor(
    private val remote: RemoteDataSource,
    private val dataStore: DataStoreOperations
) {

    fun getAllHeroes(): Flow<PagingData<Hero>> {
        return remote.getAllHeroes()
    }

    suspend fun saveOnBoardingState(completed: Boolean) {
        dataStore.saveOnBoardingState(completed)
    }

    suspend fun readOnBoardingState(): Flow<Boolean> {
        return dataStore.readOnBoardingState()
    }

}