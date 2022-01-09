package scrooge.my.apptest.di

import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import scrooge.my.apptest.data.local.specialist.SpecialistService
import scrooge.my.apptest.data.local.speciality.SpecialityService
import scrooge.my.apptest.data.model.Response
import scrooge.my.apptest.data.remote.ParsingJson
import scrooge.my.apptest.domain.GetDataRemoteUsesCase
import scrooge.my.apptest.domain.GetSpeciality
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
    fun provideGetSpeciality(specialityService: SpecialityService): GetSpeciality {
        return GetSpeciality(specialityService)
    }
}