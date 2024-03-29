package scrooge.my.apptest.di

import android.content.Context
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.qualifiers.ApplicationContext
import dagger.hilt.components.SingletonComponent
import scrooge.my.apptest.data.model.Response
import scrooge.my.apptest.data.model.Specialist
import scrooge.my.apptest.data.remote.ParsingJson
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object NetworkModule {

    @Singleton
    @Provides
    fun provideParseJson(@ApplicationContext context: Context): ParsingJson {
        return ParsingJson(context)
    }

}