package com.migc.borutoapp.data.repository

import com.migc.borutoapp.data.local.BorutoDatabase
import com.migc.borutoapp.domain.model.Hero
import com.migc.borutoapp.domain.repository.LocalDataSource

class LocalDataSourceImpl(borutoDatabase: BorutoDatabase) : LocalDataSource {

    private val heroDao = borutoDatabase.heroDao()

    override suspend fun getSelectedHero(heroId: Int): Hero {
        return heroDao.getSelectedHero(heroId = heroId)
    }

}