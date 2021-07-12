package uk.fernando.spacex.di.main


import uk.fernando.spacex.ui.SplashFragment
import uk.fernando.spacex.ui.RocketDetailFragment
import uk.fernando.spacex.ui.RocketListFragment
import dagger.Module
import dagger.android.ContributesAndroidInjector

@Module
abstract class MainFragmentModule {

    @ContributesAndroidInjector
    abstract fun contributeIntroFragment(): SplashFragment

    @ContributesAndroidInjector
    abstract fun contributeRocketListFragment(): RocketListFragment

    @ContributesAndroidInjector
    abstract fun contributeRocketDetailsFragment(): RocketDetailFragment

}