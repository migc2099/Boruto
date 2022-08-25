package com.migc.borutoapp.data.local

import androidx.room.Database
import androidx.room.RoomDatabase
import androidx.room.TypeConverter
import androidx.room.TypeConverters
import com.migc.borutoapp.data.local.dao.HeroDao
import com.migc.borutoapp.data.local.dao.HeroRemoteKeyDao
import com.migc.borutoapp.domain.model.Hero
import com.migc.borutoapp.domain.model.HeroRemoteKey

@Database(entities = [Hero::class, HeroRemoteKey::class], version = 1)
@TypeConverters(DatabaseConverter::class)
abstract class BorutoDatabase : RoomDatabase() {

    abstract fun heroDao(): HeroDao
    abstract fun heroRemoteKey(): HeroRemoteKeyDao

}