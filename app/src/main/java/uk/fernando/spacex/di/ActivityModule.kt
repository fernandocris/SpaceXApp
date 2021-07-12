package uk.fernando.spacex.di

import uk.fernando.spacex.di.main.MainFragmentModule
import uk.fernando.spacex.di.main.MainModule
import uk.fernando.spacex.di.main.MainScope
import uk.fernando.spacex.di.main.MainViewModelModule
import uk.fernando.spacex.activity.MainActivity
import dagger.Module
import dagger.android.ContributesAndroidInjector

@Module
abstract class ActivityModule {

    @MainScope
    @ContributesAndroidInjector(modules = [MainViewModelModule::class, MainModule::class, MainFragmentModule::class])
    abstract fun contributeMainActivity(): MainActivity


}