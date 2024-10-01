package com.amin.rides.di

import android.content.Context
import com.amin.rides.data.dao.VehicleDao
import com.amin.rides.data.db.AppDB
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.qualifiers.ApplicationContext
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@InstallIn(SingletonComponent::class)
@Module
class DBModule {

    @Singleton
    @Provides
    fun provideAppDatabase(@ApplicationContext context: Context): AppDB {
        return AppDB.getInstance(context)
    }


    @Provides
    fun provideVehicleDao(appDatabase: AppDB): VehicleDao {
        return appDatabase.vehicleDao()
    }
}