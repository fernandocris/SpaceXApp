package uk.fernando.spacex.di

import uk.fernando.spacex.repository.RocketRepository
import dagger.Module
import dagger.Provides

@Module
class RepositoryModule {

    @Provides
    fun provideRocketRepository(): RocketRepository = RocketRepository()
}