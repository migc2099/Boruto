package com.migc.borutoapp.domain.repository

import com.migc.borutoapp.domain.model.Hero

interface LocalDataSource {
    suspend fun getSelectedHero(heroId: Int): Hero
}