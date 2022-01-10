package scrooge.my.apptest.di

import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import scrooge.my.apptest.data.local.specialist.SpecialistService
import scrooge.my.apptest.data.local.speciality.SpecialityService
import scrooge.my.apptest.data.remote.ParsingJson
import scrooge.my.apptest.domain.GetDataRemoteUsesCase
import scrooge.my.apptest.domain.GetSpecialistUseCase
import scrooge.my.apptest.domain.GetSpecialityUseCase
import scrooge.my.apptest.domain.SaveDataLocalUseCase
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object UseCaseModule {

    @Provides
    @Singleton
    fun provideGetDataRemote(json: ParsingJson):
            GetDataRemoteUsesCase {
        return GetDataRemoteUsesCase(json)
    }

    @Provides
    @Singleton
    fun provideSaveDataLocalUseCase(
        getDataRemoteUsesCase: GetDataRemoteUsesCase,
        specialistService: SpecialistService,
        specialityService: SpecialityService
    ): SaveDataLocalUseCase {
        return SaveDataLocalUseCase(getDataRemoteUsesCase, specialistService, specialityService)
    }

    @Provides
    @Singleton
    fun provideGetSpeciality(specialityService: SpecialityService): GetSpecialityUseCase {
        return GetSpecialityUseCase(specialityService)
    }

    @Provides
    @Singleton
    fun provideGetSpecialist(specialistService: SpecialistService): GetSpecialistUseCase {
        return GetSpecialistUseCase(specialistService)
    }
}