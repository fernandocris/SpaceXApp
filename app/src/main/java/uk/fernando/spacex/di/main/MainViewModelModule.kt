package uk.fernando.spacex.di.main

import androidx.lifecycle.ViewModel
import uk.fernando.spacex.di.ViewModelKey
import uk.fernando.spacex.viewmodel.RocketListViewModel
import dagger.Binds
import dagger.Module
import dagger.multibindings.IntoMap

@Module
abstract class MainViewModelModule {

    @Binds
    @IntoMap
    @ViewModelKey(RocketListViewModel::class)
    abstract fun bindRocketListViewModel(viewModel: RocketListViewModel): ViewModel


}