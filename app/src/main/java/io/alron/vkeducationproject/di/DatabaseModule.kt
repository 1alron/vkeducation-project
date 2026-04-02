package io.alron.vkeducationproject.di

import android.app.Application
import androidx.room.Room
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import io.alron.vkeducationproject.data.source.local.AppDatabase
import io.alron.vkeducationproject.data.source.local.AppDetailsDao
import io.alron.vkeducationproject.data.source.local.AppDetailsEntityMapper
import io.alron.vkeducationproject.data.source.local.migrations.MIGRATION_1_2
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
class DatabaseModule {
    @Provides
    @Singleton
    fun provideDatabase(app: Application): AppDatabase {
        return Room.databaseBuilder(
            app,
            AppDatabase::class.java,
            AppDatabase.DATABASE_NAME
        )
            .addMigrations(MIGRATION_1_2)
            .build()
    }

    @Provides
    @Singleton
    fun provideAppDetailsDao(database: AppDatabase): AppDetailsDao {
        return database.appDetailsDao()
    }

    @Provides
    @Singleton
    fun provideAppDetailsEntityMapper(): AppDetailsEntityMapper {
        return AppDetailsEntityMapper()
    }
}