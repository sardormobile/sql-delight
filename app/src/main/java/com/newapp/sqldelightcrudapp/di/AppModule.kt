package com.newapp.sqldelightcrudapp.di

import android.app.Application
import app.cash.sqldelight.db.SqlDriver
import app.cash.sqldelight.driver.android.AndroidSqliteDriver
import com.newapp.sqldelightcrudapp.MbAppDatabase
import com.newapp.sqldelightcrudapp.data.PersonDataSource
import com.newapp.sqldelightcrudapp.data.PersonDataSourceImpl
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object AppModule {
    @Provides
    @Singleton
    fun personSqlDriver(app: Application): SqlDriver {
        return AndroidSqliteDriver(
            schema = MbAppDatabase.Schema,
            context = app,
            name = "person.db"
        )
    }

    @Provides
    @Singleton
    fun providePersonDatasource(driver: SqlDriver): PersonDataSource {
        return PersonDataSourceImpl(MbAppDatabase(driver))
    }
}