package com.migc.borutoapp.domain.repository

import androidx.paging.ExperimentalPagingApi
import androidx.paging.Pager
import androidx.paging.PagingConfig
import androidx.paging.PagingData
import com.migc.borutoapp.data.local.BorutoDatabase
import com.migc.borutoapp.data.paging_source.HeroRemoteMediator
import com.migc.borutoapp.data.remote.BorutoApi
import com.migc.borutoapp.domain.model.Hero
import com.migc.borutoapp.utils.Constants.ITEM_PER_PAGE
import kotlinx.coroutines.flow.Flow

@OptIn(ExperimentalPagingApi::class)
class RemoteDataSourceImpl(
    private val borutoApi: BorutoApi,
    private val borutoDatabase: BorutoDatabase
) : RemoteDataSource {

    private val heroDao = borutoDatabase.heroDao()

    override fun getAllHeroes(): Flow<PagingData<Hero>> {
        val pagingSourceFactory = {
            heroDao.getAllHeroes()
        }
        return Pager(
            config = PagingConfig(pageSize = ITEM_PER_PAGE),
            remoteMediator = HeroRemoteMediator(
                borutoApi = borutoApi,
                borutoDatabase = borutoDatabase
            ),
            pagingSourceFactory = pagingSourceFactory
        ).flow
    }

    override fun searchHeroes(): Flow<PagingData<Hero>> {
        TODO("Not yet implemented")
    }

}