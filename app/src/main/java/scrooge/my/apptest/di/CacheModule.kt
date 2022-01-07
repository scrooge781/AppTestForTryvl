package scrooge.my.apptest.di

import android.content.Context
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.qualifiers.ApplicationContext
import dagger.hilt.components.SingletonComponent
import scrooge.my.apptest.data.local.AppDatabase
import scrooge.my.apptest.data.local.specialist.SpecialistDao
import scrooge.my.apptest.data.local.specialist.SpecialistService
import scrooge.my.apptest.data.local.speciality.SpecialityDao
import scrooge.my.apptest.data.local.speciality.SpecialityService
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object CacheModule {

    @Singleton
    @Provides
    fun provideAppDatabase(@ApplicationContext context: Context):
            AppDatabase = AppDatabase.instance(context)

    @Singleton
    @Provides
    fun provideSpecialistDao(database: AppDatabase):
            SpecialistDao = database.specialistDao()

    @Singleton
    @Provides
    fun provideSpecialistService(dao: SpecialistDao): SpecialistService {
        return SpecialistService(dao)
    }

    @Singleton
    @Provides
    fun provideSpecialityDao(database: AppDatabase):
            SpecialityDao = database.specialityDao()


    @Singleton
    @Provides
    fun provideSpecialityService(dao: SpecialityDao): SpecialityService {
        return SpecialityService(dao)
    }

}